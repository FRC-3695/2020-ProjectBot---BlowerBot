#include <Adafruit_NeoPixel.h>

static const int STRIP_PIN = 6;

static const int 
  CHUNK_SIZE = 11;

int stage = 0;
  
Adafruit_NeoPixel strip = Adafruit_NeoPixel(120, STRIP_PIN, NEO_GRB + NEO_KHZ800);

void setup() {
  // put your setup code here, to run once:
  strip.begin();
  strip.show();
}

void loop() {
  ledStrip();
}

void ledStrip() {
  for(int i=0; i<120 / 2; i++) {
    int ledValue = i + stage;
    ledValue = (ledValue > 120 ? ledValue % 120 : ledValue);

    ledValue %= CHUNK_SIZE;
    uint32_t color = 0;
    if(ledValue < 3) { //0, 1, 2
      color = Adafruit_NeoPixel::Color(255, 0, 0);
    } else if(ledValue < 8) { //3, 4, 5, 6, 7
      color = Adafruit_NeoPixel::Color(0, 0, 0);
    } else if(ledValue < 12) { // 8, 9, 10, 11
      color = Adafruit_NeoPixel::Color(255, 255, 255);
    }

    strip.setPixelColor(i, color);
  }

  strip.show();

  stage++;
  if(stage > 120) {
    stage = 0;
  }

  delay(20);
}
