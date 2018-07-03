package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class StartGameBackground extends GameObject{
    public StartGameBackground() {
        this.renderer = new BackgroundRenderer("resources/images/welcome-scene-ban-da-sua-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
