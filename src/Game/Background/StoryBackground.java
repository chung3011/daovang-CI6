package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;
public class StoryBackground extends GameObject{

    public StoryBackground() {
        this.renderer = new BackgroundRenderer("resources/images/nhen-main-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }

}
