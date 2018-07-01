package Game;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

import java.awt.*;

public class Player extends GameObject {

    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 600;

    public Player() {
        this.renderer = new ImageRenderer("resources/images/nhennhen-pixilart.png", 60, 60);
        this.position = new Vector2D(WINDOW_WIDTH/2, WINDOW_HEIGHT/7);
        System.out.println(position.x + "  " + position.y);
    }

    public Vector2D getPosition() {
        return this.position;
    }

}
