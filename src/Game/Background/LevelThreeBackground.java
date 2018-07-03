package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class LevelThreeBackground extends GameObject{

    public LevelThreeBackground() {
        this.renderer = new BackgroundRenderer("resources/images/LevelOne/dieukienthang1bandasuaxong-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
