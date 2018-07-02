package Game;

public class Level {

    private int LEVEL_ONE_MAX_SCORE = 5;
    private int LEVEL_TWO_MAX_SCORE = 10;

//    public int level;
    public int currentScore;

    public int countSmallObjects;
    public int countLargeObjects;
    public int countMediumObjects;

    private boolean isCompleted;

    public static int level;

    public Level() {
        level += 1;
        this.currentScore = 0;
        this.reset();
    }

    public void reset() {
        this.isCompleted = false;
        this.countLargeObjects = 0;
        this.countMediumObjects = 0;
        this.countSmallObjects = 0;
    }

//    public void levelUp() {
////        this.level++;
//        this.reset();
//    }

    public void addLargeObjects() {
        this.countLargeObjects++;
    }

    public void addMediumObjects() {
        this.countMediumObjects++;
    }


    public void addSmallObjects() {
        this.countSmallObjects++;
    }

    public boolean isCompleted() {
        if (level == 1) {
            if (countLargeObjects >= 2 && countMediumObjects >= 2 && countSmallObjects >= 1) {
                this.isCompleted = true;
            }
        }

        else if (level == 2) {
            if (countLargeObjects >= 4 && countMediumObjects >= 3 && countSmallObjects >= 3 ) {
                this.isCompleted  = true;
            }
        }

        return this.isCompleted;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentScore() {
        return currentScore;
    }
}
