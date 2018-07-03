package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class StartGameBackground extends GameObject{
    public StartGameBackground() {
        this.renderer = new BackgroundRenderer("resources/images/luoinhenchuan3'-pixilart (1).png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
