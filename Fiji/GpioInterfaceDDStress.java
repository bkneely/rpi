////////////////////////////////////
// 
// 500 Hz pulse generator for RPi
// Dynamic Dispatch Stress
// Fiji Implementation
// 
////////////////////////////////////

//To compile:
// arm-linux-gnueabihf-gcc -c wiringPi.c
// javac -classpath <PATH_TO_FIJI_DIR>/lib/fivmcommon.jar GpioInterfaceDDStress.java
// cd <PATH_TO_FIJI_DIR>/bin
// ./fivmc -o gpiointerface --target POSIX-linux-gnueabihf-arm-32 --link <PATH_TO_YOUR_CODE>/wiringPi.o <PATH_TO_YOUR_CODE>/*.class

import java.lang.Thread;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import com.fiji.fivm.r1.Import;
import com.fiji.fivm.Time;
import com.fiji.fivm.ThreadPriority;

class GpioThread extends Thread 
{
	public boolean useMultiple;
	private ArrayList<GpioToggler> gpioTogglers;
	private Random rGen;

	public void run() 
	{
		// Setup the list of GPIO togglers
		gpioTogglers = new ArrayList<GpioToggler>();
		gpioTogglers.add( new AGpioToggler() );
		if( useMultiple == true )
		{
			gpioTogglers.add( new BGpioToggler() );
			gpioTogglers.add( new CGpioToggler() );
			gpioTogglers.add( new DGpioToggler() );
			gpioTogglers.add( new EGpioToggler() );
			gpioTogglers.add( new FGpioToggler() );
			gpioTogglers.add( new GGpioToggler() );
			gpioTogglers.add( new HGpioToggler() );
			gpioTogglers.add( new IGpioToggler() );
			gpioTogglers.add( new JGpioToggler() );
			gpioTogglers.add( new KGpioToggler() );
			gpioTogglers.add( new LGpioToggler() );
			gpioTogglers.add( new MGpioToggler() );
			gpioTogglers.add( new NGpioToggler() );
			gpioTogglers.add( new OGpioToggler() );
			gpioTogglers.add( new PGpioToggler() );
			gpioTogglers.add( new QGpioToggler() );
			gpioTogglers.add( new RGpioToggler() );
			gpioTogglers.add( new SGpioToggler() );
			gpioTogglers.add( new TGpioToggler() );
			gpioTogglers.add( new UGpioToggler() );
			gpioTogglers.add( new VGpioToggler() );
			gpioTogglers.add( new WGpioToggler() );
			gpioTogglers.add( new XGpioToggler() );
			gpioTogglers.add( new YGpioToggler() );
			gpioTogglers.add( new ZGpioToggler() );
		}

		int numTogglers = gpioTogglers.size();
		System.out.println( "Using " + String.valueOf( numTogglers ) + " togglers." );

		rGen = new Random();

		GpioInterfaceDDStress.wiringPiSetup();
		GpioInterfaceDDStress.pinMode( 0, 1 );

		// Select a random toggler per iter and use it to turn on/off the GPIO
		while( true )
		{	
			gpioTogglers.get( rGen.nextInt( numTogglers ) ).toggleGpio();
		}
	}
}

// Does nothing
class GpioToggler
{
	public void toggleGpio()
	{
	}
}

// Set of 26 subclasses, each of which defines a GPIO toggler function

class AGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}	

class BGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class CGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class DGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class EGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class FGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}	

class GGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class HGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class IGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class JGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class KGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}	

class LGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class MGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class NGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class OGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class PGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}	

class QGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class RGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class SGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class TGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class UGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}	

class VGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class WGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class XGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class YGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

class ZGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		long nextTime = 0;
		GpioInterfaceDDStress.digitalWrite( 0, 1 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
		GpioInterfaceDDStress.digitalWrite( 0, 0 );
		nextTime = Time.nanoTimePrecise() + 1000000;
		Time.sleepAbsolute( nextTime );
	}
}

public class GpioInterfaceDDStress
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
		gthread.useMultiple = ( args.length > 0 );
		gthread.setPriority( ThreadPriority.RR_MAX );
		gthread.start();
        }
}
