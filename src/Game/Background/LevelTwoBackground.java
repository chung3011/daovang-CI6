package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class LevelTwoBackground extends GameObject {
    public LevelTwoBackground() {
        this.renderer = new BackgroundRenderer("resources/images/LevelTwo/dieukienthang2bandasuaxong-pixilart.png",
                Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
        System.out.println("level 2 background");
    }
}
