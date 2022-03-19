class Dragon
{
  int x, y;
  int speedX;
  int frames = 0;
  PImage dragon1 = loadImage("dragonN1.png");
  PImage dragon2 = loadImage("dragonN2.png");
  PImage dragon3 = loadImage("dragonN3.png");
  PImage dragon4 = loadImage("dragonN4.png");
  PImage dragon5 = loadImage("dragonN5.png");
  PImage dragon6 = loadImage("dragonN6.png");
  PImage dragon7 = loadImage("dragonN7.png");

  //constructor
  Dragon(int x, int y, int speedX) {
    this.x = x;
    this.y = y;
    this.speedX = speedX;
  }

  void render()
  {

    if (frames > 0 & frames <= 10) {
      image(dragon1, this.x, this.y);
    } else if (frames > 10 & frames <= 20) {
      image(dragon2, this.x, this.y);
    } else if (frames > 20 & frames <= 30) {
      image(dragon3, this.x, this.y);
    } else if (frames > 30 & frames <= 40) {
      image(dragon4, this.x, this.y);
    } else if (frames > 40 & frames <= 50) {
      image(dragon5, this.x, this.y);
    } else if (frames > 50 & frames <= 60) {
      image(dragon6, this.x, this.y);
    } else 
    {
      image(dragon7, this.x, this.y);
    }

    frames++ ; // change frame over

    if (frames > 90 )
      frames = 0;
  }

  void move()
  {
    x = x - speedX;

    if (y>height)

      y = 670;
  }

  void update()
  {
    move();
    render();
  }
}
