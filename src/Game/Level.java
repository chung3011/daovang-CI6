package Game;

import Action.WaitAction;
import Base.FrameCounter;
import Game.ObjectsToCatch.IconGenerator;
import scene.GamePlayScene;
import scene.SceneManager;

public class Level {

    private int LEVEL_ONE_MAX_SCORE = 5;
    private int LEVEL_TWO_MAX_SCORE = 10;

    public int countSmallObjects;
    public int countLargeObjects;
    public int countMediumObjects;

    private FrameCounter frameCounter = new FrameCounter(30);


    private boolean isCompleted;

    public static int level;

    public Level() {
        level += 1;
        this.reset();
    }

    public void reset() {
        this.isCompleted = false;
        this.countLargeObjects = 0;
        this.countMediumObjects = 0;
        this.countSmallObjects = 0;
    }


    public void addLargeObjects() {
        this.countLargeObjects++;
    }

    public void addMediumObjects() {
        this.countMediumObjects++;
    }


    public void addSmallObjects() {
        this.countSmallObjects++;
    }

    public void isCompleted() {
        if (level == 1) {
            if (countLargeObjects >= 2 && countMediumObjects >= 2 && countSmallObjects >= 1) {
//            if (countLargeObjects >= 1 || countSmallObjects >= 1 || countMediumObjects >= 1) {
                this.isCompleted = true;
                while(!frameCounter.run()) {

                }
                frameCounter.reset();
                IconGenerator.instance.resetVerticalPos();
                System.out.println("level up!");
                SceneManager.instance.changeScene(new GamePlayScene());
            }
        }

        else if (level == 2) {
            if (countLargeObjects >= 4 && countMediumObjects >= 3 && countSmallObjects >= 3 ) {
                this.isCompleted  = true;
                System.out.println("YOU WIN!");
                System.exit(1);
            }
        }

    }

    public int getLevel() {
        return level;
    }

}
