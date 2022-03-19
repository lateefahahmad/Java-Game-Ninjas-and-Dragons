//Class SplashScreen {  Create splash screen by using high level class or construct
// switch the game states/level/ by using and enum listing diff modes 
// GameMode currentGameMode = GameMode.PLAYING;
//} 
// use switch statments to change state like a loop

// global variables
//STEP 1 FOR ARRAY L
ArrayList<Dragon> dragonList = new ArrayList(); // start of arraylist step 1 and empty to begin with. use add method to add objects
ArrayList<Chest> chestList = new ArrayList();
Ninja run1; //CREDIT DRAGON
PImage backGround;
int bgX = 0;
final int SPLASHSCREEN = 2;
final int PLAYING =0; //permanently fixed @ 0#

int gameMode = PLAYING;
final int FINISHED = 1; 
int repeatDragon = 10;
int spawnTimer = 0;
int speedRun = 5;
int scoreIncrease;
CountDown timer; //declare instance variable of CountDown
int splashDuration;
PImage gameOver;
//PImage splashs = loadImage("dark1.jpg"); // splash screen
//SplashScreen splashTimer;

void setup()
{
  size(1500, 900);

  backGround = loadImage("dark.jpg");
  backGround.resize(width, height);
  timer = new CountDown(60);
  //splashTimer = new SplashScreen(3);//call CountDown constructor – 60 secs
  run1 = new Ninja(20, 200, 5);
  gameOver = loadImage("gameover.png");

  //STEP 2 FOR ARRAY L
  for ( int i = 0; i < 3; i++) {
    dragonList.add(new Dragon( width+(int) random(500), (int) random(650), 7) ); // adding new dragon & also creating new dragon object as we dont have any dragons made @ this point e.g. 'new Dragon'
  }// 10 dragons/loops/iterations
  println(dragonList.size() ); // helps see how many dragons have been added

  for ( int i = 0; i < 1; i++) {
    chestList.add(new Chest( width+(int) random(700), (int) random(500) ));
  }
}

// rendering animations, images, bg.
void draw() // 60 times a second
{
  if (gameMode == PLAYING) {
    image(backGround, bgX, 0); // draw bg twice
    image(backGround, bgX+backGround.width, 0);
    bgX -= 4; // move bg 5 pixels to left  // how to stop the bg blurring?
    if (bgX == -backGround.width)
      bgX=0; // wrap background
    run1.render();

    //STEP 3 FOR ARRAY L
    for (int i = 0; i < dragonList.size(); i++)  // '.size' as the number of birds is going to constantly change so a number limit would not work
    {
      Dragon currentDragon = dragonList.get(i); // i is 0 so pulls the first object in array, 1 would be the 2nd, so on. 

      currentDragon.update(); // used a variable name instead of chaining method, using .update etc
      // instead of birdList.get we can now put = currentBird


      for (int j = 0; j < chestList.size(); j++) {
        Chest currentChest = chestList.get(j); // doesnt create new chests objects remember!
        currentChest.update();


        //if player crashes into chest, remove, score++  COME BACK TO LATER TO CHANGE NAMES 
        if (currentChest.CollideFunction(run1)) { 
          chestList.remove(j);  
          scoreIncrease++;
        }
      }

      // text on screen, scoring display, game over image  
      text("score: " + scoreIncrease, 1300, 75);
      if (run1.crash( currentDragon )) {
        gameMode = FINISHED;
        background(0); // only black background works? ref - bouncing ball
        image(gameOver, 470, 120);
        print("crash!");

        if (i == width) //   { // ? remove dragons from array once they've passed ?

          dragonList.remove(i); // i coresponds to the position
        print("removed!");
      }
    }

    // spawn timer. adding new objects
    spawnTimer++; // adds 1 to spawnTimer

    if (spawnTimer % 120 == 0) { // every 1 second bcos void draw is every 60 second

      dragonList.add(new Dragon( width+(int) random(500), (int) random(700), 7) ); // every second creates 1 new dragon
      chestList.add(new Chest( width+(int) random(400), (int) random(600) ));
    }

    // timer section. after 60 seconds ends game.
    textSize(35);
    text(timer.GetRemainingTime(), 20, 75); //display seconds remaining top left
    if (timer.GetRemainingTime() == 0) {
      gameMode = FINISHED;
      background(0); // back bg
      clear(); // won't clear objects off screen after game over ?
      image(gameOver, 470, 120);
    }
  }
}

void keyPressed() {

  if (key == CODED) {
    if (keyCode == UP && run1.y > 0)
      run1.y = run1.y - 15;
    else if (keyCode == DOWN && run1.y < height - 150) // 700 canvas y size - 250 stops runner from going off screen/below 700 canvas line
      run1.y = run1.y + 15;

    else if (keyCode == RIGHT && run1.x < width - 130) // 130 is size of my player
      run1.x = run1.x + 10; // move it right

    else if (keyCode == LEFT && run1.x > 0) //1500
      run1.x = run1.x - 20; // enables ninja to go backwards
  }
}
