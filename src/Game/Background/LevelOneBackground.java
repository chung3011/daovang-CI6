package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class LevelOneBackground extends GameObject {
    public LevelOneBackground() {

        this.renderer = new BackgroundRenderer("resources/images/LevelOne/winningc1-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
