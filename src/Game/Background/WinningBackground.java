package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class WinningBackground extends GameObject {
    public WinningBackground() {
    this.renderer = new BackgroundRenderer("resources/images/LevelTwo/dieukienthang2bandasuaxong-pixilart.png",
            Constant.Window.WIDTH,
            Constant.Window.HEIGHT);
    }
}
