class Chest {

  int x, y;
  int counter = 0;
  final int speedChest = 1;
  PImage chest1 = loadImage("chest1.png");
  PImage chest2 = loadImage("chest2.png");
  PImage chest3 = loadImage("chest3.png");

  //constructor
  Chest(int x, int y) {
    this.x = x;
    this.y = y;
  }

  void render() {

    if (counter > 5 & counter <= 10) {
      image(chest1, this.x, this.y);
      chest1.resize(500, 500);
    } else if (counter > 10 & counter <= 15) {
      image(chest2, this.x, this.y);
    } else if (counter > 15 & counter <= 20) {

      image(chest1, this.x, this.y);
    } else {
      image(chest3, this.x, this.y);
    }
    counter++ ; // change frame over. 
    // 1. fix the animation frames speed?

    if (counter > 200 )
      counter = 0;

    //for (int chest=0; chest<3; chest++) {
    //  if (chest<width)
    //    chest++;
    //}
  }

  void move() {

    x = x - speedChest;
  }

  void update()
  {
    move();
    render();
  }

  Boolean CollideFunction(Ninja passedPlayer)
  {
    int xPos = passedPlayer.x;
    int yPos = passedPlayer.y;

    Boolean collideFunction;
    collideFunction = (xPos >= x  && xPos <= (x + 450)) && (yPos >= y && yPos <= (y + 450));



    return collideFunction;
  }

  //boolean crash(Dragon run1) {
  //  return abs(this.x-run1.x) < 91 && abs(this.y-run1.y) <44; }
}
