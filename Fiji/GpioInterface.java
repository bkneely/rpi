////////////////////////////////////
// 
// 500 Hz pulse generator for RPi
// Fiji Implementation
// 
////////////////////////////////////

//To compile:
// arm-linux-gnueabihf-gcc -c wiringPi.c
// javac -classpath <PATH_TO_FIJI_DIR>/lib/fivmcommon.jar GpioInterface.java
// cd <PATH_TO_FIJI_DIR>/bin
// ./fivmc -o gpiointerface --target POSIX-linux-gnueabihf-arm-32 --link <PATH_TO_YOUR_CODE>/wiringPi.o <PATH_TO_YOUR_CODE>/*.class

import java.lang.Thread;
import com.fiji.fivm.r1.Import;
import com.fiji.fivm.Time;
import com.fiji.fivm.ThreadPriority;

// Thread to generate 500 Hz pulse
class GpioThread extends Thread 
{
	public void run() 
	{
		// Setup the GPIO
		long nextTime = 0;
		GpioInterface.wiringPiSetup();
		GpioInterface.pinMode( 0, 1 );

		// Turn on GPIO, sleep for 1 ms, turn off gpio, sleep for 1 ms, repeat...
		while( true )
		{
			GpioInterface.digitalWrite( 0, 1 );
			nextTime = Time.nanoTimePrecise() + 1000000;
			Time.sleepAbsolute( nextTime );
			GpioInterface.digitalWrite( 0, 0 );
			nextTime = Time.nanoTimePrecise() + 1000000;
			Time.sleepAbsolute( nextTime );
		}
	}
}

public class GpioInterface
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
		GpioThread gthread = new GpioThread();
		gthread.setPriority( ThreadPriority.RR_MAX );
		gthread.start();
        }
}
