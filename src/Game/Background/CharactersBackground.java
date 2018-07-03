package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class CharactersBackground extends GameObject{
    public CharactersBackground() {

        this.renderer = new BackgroundRenderer("resources/images/presspacetocontinue-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
