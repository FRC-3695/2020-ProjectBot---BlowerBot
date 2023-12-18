#include <Adafruit_NeoPixel.h>

const int
LEFTPIN = 5,
RIGHTPIN = 6;


/**
 * TO WHOM IT MAY CONCERN:
 * DO NOT CLOSE THIS WINDOW UNTIL THE LEDS ARE GOOD
 * 
 * To push the code:
 * Connect Arduino and select it under Tools->Port->COMX (Arduino/Genuino Uno)
 * push "Upload" button (the arrow pointing right)
 */

/**
   LED code for the Spirit bot!
   Originally written by Colton Kreischer
   Modified for 2 LED strips by Brach Knutson
*/

// Parameter 1 = number of pixels in strip
// Parameter 2 = pin number (most are valid)
// Parameter 3 = pixel type flags, add together as needed:
//   NEO_KHZ800  800 KHz bitstream (most NeoPixel products w/WS2812 LEDs)
//   NEO_KHZ400  400 KHz (classic 'v1' (not v2) FLORA pixels, WS2811 drivers)
//   NEO_GRB     Pixels are wired for GRB bitstream (most NeoPixel products)
//   NEO_RGB     Pixels are wired for RGB bitstream (v1 FLORA pixels, not v2)
Adafruit_NeoPixel strip1 = Adafruit_NeoPixel(120, LEFTPIN, NEO_RGBW + NEO_KHZ800);
Adafruit_NeoPixel strip2 = Adafruit_NeoPixel(120, RIGHTPIN, NEO_RGBW + NEO_KHZ800);

void setup() {
  strip1.begin();
  strip1.show(); // Initialize all pixels to 'off'

  strip2.begin();
  strip2.show();
}

void loop() {
  // Some example procedures showing how to display to the pixels:
  rainbowCycle(1);
}

// Slightly different, this makes the rainbow equally distributed throughout
void rainbowCycle(uint8_t wait) {
  uint16_t i, j;

  for (j = 0; j < 256 * 5; j++) { // 5 cycles of all colors on wheel
    for (i = 0; i < strip1.numPixels(); i++) {
      uint32_t wheelValue = Wheel(((i * 256 / strip1.numPixels()) + j) & 255);
      strip1.setPixelColor(i, wheelValue);
      strip2.setPixelColor(i, wheelValue);
    }
    strip1.show();
    strip2.show();
    delay(wait);
  }
}

// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) {
  if (WheelPos < 85) {
    return strip1.Color(WheelPos * 3, 255 - WheelPos * 3, 0, 255);
  } else if (WheelPos < 170) {
    WheelPos -= 85;
    return strip1.Color(255 - WheelPos * 3, 0, WheelPos * 3, 255);
  } else {
    WheelPos -= 170;
    return strip1.Color(0, WheelPos * 3, 255 - WheelPos * 3, 255);
  }
}
