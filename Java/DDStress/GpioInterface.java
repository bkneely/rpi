////////////////////////////////////
// 500 Hz pulse generator for RPi
// Dynamic Dispatch Stress
// 
// Assumes library is loaded at
// /home/pi/PiGpio/wiringPi.so
////////////////////////////////////

// To compile:
// javac GpioInterface.java
// javah -jni GpioInterface
// arm-linux-gnueabihf-gcc -I/usr/lib/jvm/java-6-openjdk-amd64/include -shared wiringPi.c -o wiringPi.so

import java.lang.Thread;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

// Thread to generate 500 Hz pulse
class GpioThread extends Thread 
{
	public boolean useMultiple;
	private ArrayList<GpioToggler> gpioTogglers;
	private Random rGen;

	public void run() 
	{
		// Create the set of GPIO togglers
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

		GpioInterface.wiringPiSetup();
		GpioInterface.pinMode( 0, 1 );

		// Select a different toggler per iter to turn on/off the GPIO
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


// 26 different child classes to toggle the GPIO

class AGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}	

class BGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class CGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class DGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class EGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class FGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}	

class GGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class HGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class IGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class JGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class KGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}	

class LGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class MGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class NGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class OGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class PGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}	

class QGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class RGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class SGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class TGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class UGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}	

class VGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class WGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class XGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class YGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

class ZGpioToggler extends GpioToggler
{
	public void toggleGpio()
	{
		GpioInterface.digitalWrite( 0, 1 );
		GpioInterface.delay( 1000000 );
		GpioInterface.digitalWrite( 0, 0 );
		GpioInterface.delay( 1000000 );
	}
}

public class GpioInterface
{
	public static native void pinMode( int pin, int mode );
	public static native void digitalWrite( int pin, int value );
	public static native void delay( int time );
	public static native void wiringPiSetup();

        public static void main(String[] args)
        {
                GpioThread gthread = new GpioThread();
		gthread.setPriority( Thread.MAX_PRIORITY );
		gthread.useMultiple = ( args.length > 0 );
		gthread.start();
        }
        static
	{
                System.load("/home/pi/PiGpio/wiringPi.so");
        }
}
