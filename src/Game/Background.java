package Game;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;
import Renderer.ImageRenderer;
import Renderer.Renderer;

import java.awt.*;

public class Background extends GameObject {

//    Renderer renderer;

    public Background() {
        this.renderer = new BackgroundRenderer("resources/images/luoinhenchuan3'-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }

//    public Background() {
//        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
//    }
//

}