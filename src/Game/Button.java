package Game;

import Base.GameObject;
import Base.Vector2D;

import Renderer.ImageRenderer;

import java.awt.*;

public class Button extends GameObject {

    public String label;
    public int width, height;


    public Button( Vector2D position,int width, int height, String label, String path){
        this.position = position;
        this.width = width;
        this.height = height;
        this.renderer = new ImageRenderer(path,width,height);
        this.label = label;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

    }
}

