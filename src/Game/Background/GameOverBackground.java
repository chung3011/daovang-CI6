package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class GameOverBackground extends GameObject {
    public GameOverBackground() {
        this.renderer = new BackgroundRenderer("resources/images/luoinhenchuan3'-pixilart (1).png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
