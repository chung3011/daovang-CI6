package Game.ObjectsToCatch.SmallObject;

import Base.GameObject;
import Base.Vector2D;
import Constant.Constant;
import Renderer.ImageRenderer;

public class SmallObjectIcon extends GameObject {

    public SmallObjectIcon() {
        this.renderer = new ImageRenderer("resources/images/ongmat-pixilart.png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {
    }
}
