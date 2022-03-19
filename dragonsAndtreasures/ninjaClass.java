//class, members
//constuctor
//void render
//void move

class Ninja
{ //members

  int x, y;
  int speed = 5;
  int animationCounter = 0;
  int speedY;
  PImage run1, run2, run3, run5, run6, run7, run8; // img needs declaring in class here

  // constructor part of class - building it together
  Ninja(int x, int y, int speedY)
  {
    this.x = x;
    this.y = y;
    this.speedY = speedY;
    run1 = loadImage("ninja1.png");
    run2 = loadImage("ninja2.png");
    run3 = loadImage("ninja3.png");
    run5 = loadImage("ninja1.png");
    run6 = loadImage("ninja6.png");
    run7 = loadImage("ninja7.png");
    run8 = loadImage("ninja8.png");
  }

  void render()
  {

    if (animationCounter >0 & animationCounter <=10)  // if animationcounter is greater than 0 and less than 10... then upload this first image of... in this x,y position. 
    {
      image(run1, this.x, this.y);
    } else if (animationCounter >10 & animationCounter <=20)
    {
      image(run2, this.x, this.y);
    } else if (animationCounter >20 & animationCounter <=30)
    {
      image(run3, this.x, this.y);
    } else if (animationCounter >40 & animationCounter <=50)
    {
      image(run5, this.x, this.y);
    } else if (animationCounter >50 & animationCounter <=60)
    {
      image(run6, this.x, this.y);
    } else if (animationCounter >60 & animationCounter <=70)
    {
      image(run7, this.x, this.y);
    } else
    {
      image(run8, this.x, this.y);
    }

    animationCounter = animationCounter + 1; // changes animation over

    if (animationCounter >80) // as the highest numb times the frame is shown is 60^^
    {
      animationCounter = 0;
    }
  }

  void move()
  {
    this.x += speed; // this and move.render commented as we dont want character to move with speed along canvas.
    if (this.x>width)

      this.x = 0;  // if it goes past canvas, reset to 0/start
  }

  boolean crash(Dragon run1) {
    return abs(this.x-run1.x) < 91 && abs(this.y-run1.y) <44;
  }

  //    boolean crash( Dragon currentDragon ) // distance
  //{
  //  if(currentDragon == null)
  //  return false;

  //  float distanceX = run1.x - (this.x + 20);
  //  float distanceY = run1.x - (this.y + 20);
  //  float distance = sqrt(distanceX * distanceX + distanceY * distanceY);
  //  return (distance<30);
}
