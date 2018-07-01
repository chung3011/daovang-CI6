package Game;

import Base.GameObject;
import Renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
    }


}