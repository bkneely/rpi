/***********************************
* Basic GPIO Driver for Rasberry Pi
* Adapted from wiringPi.com implementation
***********************************/

#ifndef	__WIRING_PI_H__
#define	__WIRING_PI_H__

// Handy defines

// Deprecated
#define	NUM_PINS	17

#define	WPI_MODE_PINS		 0
#define	WPI_MODE_GPIO		 1
#define	WPI_MODE_GPIO_SYS	 2
#define	WPI_MODE_PHYS		 3
#define	WPI_MODE_PIFACE		 4
#define	WPI_MODE_UNINITIALISED	-1

// Pin modes

#define	INPUT			 0
#define	OUTPUT			 1
#define	PWM_OUTPUT		 2
#define	GPIO_CLOCK		 3

#define	LOW			 0
#define	HIGH			 1

// Pull up/down/none

#define	PUD_OFF			 0
#define	PUD_DOWN		 1
#define	PUD_UP			 2

// PWM

#define	PWM_MODE_MS		0
#define	PWM_MODE_BAL		1

// Interrupt levels

#define	INT_EDGE_SETUP		0
#define	INT_EDGE_FALLING	1
#define	INT_EDGE_RISING		2
#define	INT_EDGE_BOTH		3

// Threads

#define	PI_THREAD(X)	void *X (void *dummy)

// Failure modes

#define	WPI_FATAL	(1==1)
#define	WPI_ALMOST	(1==2)

void wiringPiSetup();
void delayMicroseconds( int time );
void delay( int time );
void digitalWrite( int pin, int value );
int digitalRead ( int pin );
void pinMode( int pin, int mode );

#endif
