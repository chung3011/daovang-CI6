package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class GameOverAnNhieu extends GameObject {
    public GameOverAnNhieu() {
        this.renderer = new BackgroundRenderer("resources/images/chet-do-an-qua-nhieu-banfinal-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
