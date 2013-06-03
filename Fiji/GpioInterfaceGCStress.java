////////////////////////////////////
// 
// 500 Hz pulse generator for RPi
// Garbage Collector Stress
// Adapted from http://nerds-central.blogspot.com/2011/11/comparing-java-7-garbage-collectors.html
//
// Fiji Implementation
// 
////////////////////////////////////

//To compile:
// arm-linux-gnueabihf-gcc -c wiringPi.c
// javac -classpath <PATH_TO_FIJI_DIR>/lib/fivmcommon.jar GpioInterfaceGCStress.java
// cd <PATH_TO_FIJI_DIR>/bin
// ./fivmc -o gpiointerface --target POSIX-linux-gnueabihf-arm-32 --link <PATH_TO_YOUR_CODE>/wiringPi.o <PATH_TO_YOUR_CODE>/*.class

import java.lang.Thread;
import com.fiji.fivm.r1.Import;
import com.fiji.fivm.Time;
import com.fiji.fivm.ThreadPriority;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

// Thread to generate 500 Hz pulse
class GpioThread extends Thread 
{
	public void run() 
	{
		long nextTime = 0;
		GpioInterfaceGCStress.wiringPiSetup();
		GpioInterfaceGCStress.pinMode( 0, 1 );
		while( true )
		{
			GpioInterfaceGCStress.digitalWrite( 0, 1 );
			nextTime = Time.nanoTimePrecise() + 1000000;
			Time.sleepAbsolute( nextTime );
			GpioInterfaceGCStress.digitalWrite( 0, 0 );
			nextTime = Time.nanoTimePrecise() + 1000000;
			Time.sleepAbsolute( nextTime );
		}
	}
}

// GC Stress Tester
// Repeadly adds 1,000,000 items to an array (young garbage)
// Every 100th iter, clears an array and adds 1,000,000 items to it (old garbage)
class GCStressTester
{
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

public class GpioInterfaceGCStress
{
	@Import
        public static native void pinMode( int pin, int mode );

	@Import
	public static native void digitalWrite( int pin, int value );

	@Import
	public static native void delay( int time );

	@Import
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
		gthread.setPriority( ThreadPriority.RR_MAX );
		gthread.start();
        }
}
