package Game;

import Base.GameObject;
import Renderer.BackgroundRenderer;
import Renderer.Renderer;

import java.awt.*;

public class Background extends GameObject {

//    Renderer renderer;

    public Background() {
        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
    }


}