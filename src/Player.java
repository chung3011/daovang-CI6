public class Player {

    private Vector2D position;

    private final int WIDTH = 1650;
    private final int HEIGHT = 1080;

    public Player() {
        this.position = new Vector2D(WIDTH/3 + 200, HEIGHT/7);
    }

    public Vector2D getPosition() {
        return this.position;
    }
}
