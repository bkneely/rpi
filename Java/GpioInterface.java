////////////////////////////////////
// 500 Hz pulse generator for RPi
// 
// Assumes library is loaded at
// /home/pi/PiGpio/wiringPi.so
////////////////////////////////////

// To compile:
// javac GpioInterface.java
// javah -jni GpioInterface
// arm-linux-gnueabihf-gcc -I/usr/lib/jvm/java-6-openjdk-amd64/include -shared wiringPi.c -o wiringPi.so

import java.lang.Thread;

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

class GpioInterface
{
        public static native void pinMode( int pin, int mode );
	public static native void digitalWrite( int pin, int value );
	public static native void delay( int time );
	public static native void wiringPiSetup();

        public static void main(String[] args)
        {
                GpioThread gthread = new GpioThread();
		gthread.setPriority( Thread.MAX_PRIORITY );
		gthread.start();
        }
        static
	{
                System.load("/home/pi/PiGpio/wiringPi.so");
        }
}
