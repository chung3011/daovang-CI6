package Game.ObjectsToCatch.MediumObject;

import Base.GameObject;
import Base.Vector2D;
import Constant.Constant;
import Renderer.ImageRenderer;

public class MediumObjectIcon extends GameObject {

    public MediumObjectIcon() {
        this.renderer = new ImageRenderer("resources/images/chuonchuon-pixilart.png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {
    }
}
