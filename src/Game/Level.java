package Game;

import Action.WaitAction;
import Base.FrameCounter;
import Constant.Constant;
import scene.GamePlayScene;
import scene.LevelTwoScene;
import scene.SceneManager;

public class Level {

    private int LEVEL_ONE_MAX_SCORE = 5;
    private int LEVEL_TWO_MAX_SCORE = 10;

    public int countSmallObjects;
    public int countLargeObjects;
    public int countMediumObjects;



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
        IconGenerator.instance.resetVerticalPos();

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
            if (countLargeObjects >= Constant.Level.largeLv1 && countMediumObjects >= Constant.Level.mediumLv1 && countSmallObjects >= Constant.Level.smallLv1) {
                this.isCompleted = true;
                System.out.println("level up!");
                this.reset();
                SceneManager.instance.changeScene(new LevelTwoScene());
            }
        }

        else if (level == 2) {
            if (countLargeObjects >= Constant.Level.largeLv2 && countMediumObjects >= Constant.Level.mediumLv2 && countSmallObjects >= Constant.Level.smallLv2 ) {
                this.isCompleted  = true;
                System.out.println("YOU WIN!");
                this.reset();
                System.exit(1);
            }
        }

    }

//    public void gameOverReset() {
//        this.isCompleted = false;
//        this.countLargeObjects = 0;
//        this.countMediumObjects = 0;
//        this.countSmallObjects = 0;
//        IconGenerator.instance.resetVerticalPos();
//    }

    public int getLevel() {
        return level;
    }

}
