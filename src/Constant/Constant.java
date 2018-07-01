package Constant;

import java.util.Arrays;
import java.util.List;

public class Constant {

    public static class Window {
        public static final int WIDTH = 1024;
        public static final int HEIGHT = 600;
    }

    public static class Canvas {
        public static final int WIDTH = 1024;
        public static final int HEIGHT = 660;
    }

    public static class Speed {
        public static final float GRAVITY = 1f;
        public static final float FLY_SPEED = 1.5f;
        public static final float HORIZONTAL_SPEED = 2f;
        public static final int DELAY_VERTICAL = 6;
        public static final float DEAD_VELOCIY = 4.5f;

    }


    public static class Player {
        public static final int WIDTH = 60;
        public static final int HEIGHT = 40;
    }

    public static class Gift {
        public static final int WIDTH = 25;
        public static final int HEIGHT = 25;
    }

    public static class Station {
        public static final int WIDTH = 65;
        public static final int HEIGHT = 30;
    }

    public static class GiftTaker {
        public static final int WIDTH = 20;
        public static final int HEIGHT = 35;
    }

    public static class Scene {
        public static final String[] ARRAY_PATH_SCENE = {
                "assets/maps/ATA-MAPS/atamap1.1.json",
                "assets/maps/ATA-MAPS/atamap2.json",
                "assets/maps/ATA-MAPS/atamap3.json"
        };

    }

    public static class Button {
        public static final String START = "Start Button";
        public static final String REPLAY_ALL = "Replay All";
        public static final String REPLAY_ONE = "Replay One";
        public static final String NEXT_SCENE = "Next Scene";
        public static final String SCORE = "SCORE";
        public static final String BACK_HOME = "Back home";

    }


}
