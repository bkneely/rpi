////////////////////////////////////
// 500 Hz pulse generator for RPi
// With Garbage Collector Stress
// Adapted from http://nerds-central.blogspot.com/2011/11/comparing-java-7-garbage-collectors.html
// 
// Assumes library is loaded at
// /home/pi/PiGpio/wiringPi.so
////////////////////////////////////

// To compile:
// javac GpioInterface.java
// javah -jni GpioInterface
// arm-linux-gnueabihf-gcc -I/usr/lib/jvm/java-6-openjdk-amd64/include -shared wiringPi.c -o wiringPi.so

import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

// Thread to generate the 500 Hz pulse
class GpioThread extends Thread 
{
	public void run() 
	{
		// Setup the GPIO
		GpioInterface.wiringPiSetup();
		GpioInterface.pinMode( 0, 1 );
		while( true )
		{
			// Turn on the GPIO, delay 1 ms, turn off, delay 1 ms, repeat...
			GpioInterface.digitalWrite( 0, 1 );
			GpioInterface.delay( 1000000 );
			GpioInterface.digitalWrite( 0, 0 );
			GpioInterface.delay( 1000000 );
		}
	}
}

// GC Stress Tester
// Repeadly adds 1,000,000 items to an array (young garbage)
// Every 100th iter, clears an array and adds 1,000,000 items to it (old garbage)
class GCStressTester
{
	// Arrays for GC stress
	private List<String> outerStore = new ArrayList<String>(1000000);
	private List<String> oldStore = new ArrayList<String>(1000000);
	public static int nThread=3;
 
	public void go()
	{
		// Forever
		while( true )
		{
			// Do this 1000 times
			for(int i=0;i<1000;++i)
			{
				// Every 100th iter, clear and realloc the old generation garbage
				if(i%100==0)
				{
					doOld();
				}
				// Create the young garbage
				for(int j=0;j<1000000/nThread;++j)
				{
					outerStore.add(((Integer)j).toString());
				}
				// Delete it
				outerStore.clear();
			}
		}
	}
 
 	// Create old garbage
 	private void doOld()
	{
  		oldStore.clear();
  		for(int j=0;j<1000000/nThread;++j)
		{
   			oldStore.add(((Integer)j).toString());
  		}
 	}

}

class GpioInterface
{
        public static native void pinMode( int pin, int mode );
	public static native void digitalWrite( int pin, int value );
	public static native void delay( int time );
	public static native void wiringPiSetup();

        public static void main(String[] args)
        {
		for(int i=0;i<GCStressTester.nThread;++i)
		{
			new Thread()
			{
				public void run()
				{
					new GCStressTester().go();
				} 
			}.start();
		}

                GpioThread gthread = new GpioThread();
		gthread.setPriority( Thread.MAX_PRIORITY );
		gthread.start();
        }
        static
	{
                System.load("/home/pi/PiGpio/wiringPi.so");
        }
}
