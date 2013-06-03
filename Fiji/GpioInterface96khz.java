////////////////////////////////////
// 
// 96kHz pulse generator for RPi
// Fiji Implementation
// 
////////////////////////////////////

//To compile:
// arm-linux-gnueabihf-gcc -c wiringPi.c
// javac -classpath <PATH_TO_FIJI_DIR>/lib/fivmcommon.jar GpioInterface96khz.java
// cd <PATH_TO_FIJI_DIR>/bin
// ./fivmc -o gpiointerface --target POSIX-linux-gnueabihf-arm-32 --link <PATH_TO_YOUR_CODE>/wiringPi.o <PATH_TO_YOUR_CODE>/*.class

// Note: To sample audio at 96kHz, we need 10416/2 ns clock. Assumes that the SPI driver will handle the clk rate for the ADC.

import java.lang.Thread;
import com.fiji.fivm.r1.Import;
import com.fiji.fivm.Time;
import com.fiji.fivm.ThreadPriority;

class GpioThread extends Thread 
{
	public void run() 
	{
		GpioInterface96khz.wiringPiSetup();
		GpioInterface96khz.pinMode( 0, 1 );
		while( true )
		{
			GpioInterface96khz.digitalWrite( 0, 1 );
			Time.sleepAbsolute( Time.nanoTimePrecise() + 5208 );
			GpioInterface96khz.digitalWrite( 0, 0 );
			Time.sleepAbsolute( Time.nanoTimePrecise() + 5208 );
		}
	}
}

public class GpioInterface96khz
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
