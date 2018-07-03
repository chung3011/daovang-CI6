package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class LevelOneBackground extends GameObject {
    public LevelOneBackground() {

        this.renderer = new BackgroundRenderer("resources/images/LevelOne/dieukienthang1bandasuaxong-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
