public class Player extends GameObject {


    private final int WINDOW_WIDTH = 1650;
    private final int WINDOW_HEIGHT = 1080;

    public Player() {
        this.position = new Vector2D(WINDOW_WIDTH/3 + 200, WINDOW_HEIGHT/7);
    }

    public Vector2D getPosition() {
        return this.position;
    }
}
