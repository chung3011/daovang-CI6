package Game;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

import java.awt.*;

public class Player extends GameObject {

    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 600;

    public Player() {
<<<<<<< HEAD
        this.position = new Vector2D(WINDOW_WIDTH/3 + 200, WINDOW_HEIGHT/7);
        this.renderer = new ImageRenderer("resources/images/nhennhen-pixilart.png", 60, 60);
=======
        this.position = new Vector2D(WINDOW_WIDTH/2, WINDOW_HEIGHT/7);
        System.out.println(position.x + "  " + position.y);
>>>>>>> 85ac4d6742c3a75572e7b4f62eb629bcb5b0eeb3
    }

    public Vector2D getPosition() {
        return this.position;
    }

}
