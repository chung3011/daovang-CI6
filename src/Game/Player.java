package Game;

import Base.GameObject;
import Base.Vector2D;

import java.awt.*;

public class Player extends GameObject {

    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 600;

    public Player() {
        this.position = new Vector2D(WINDOW_WIDTH/3 + 200, WINDOW_HEIGHT/7);
        System.out.println(position.x + "  " + position.y);
    }

    public Vector2D getPosition() {
        return this.position;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval((int) this.position.x - 3, (int) this.position.y - 4, 7, 7);
    }

}
