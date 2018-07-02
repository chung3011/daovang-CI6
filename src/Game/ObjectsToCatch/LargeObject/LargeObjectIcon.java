package Game.ObjectsToCatch.LargeObject;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Anchor;
import Physic.BoxCollider;
import Renderer.ImageRenderer;

public class LargeObjectIcon extends GameObject {


    public LargeObjectIcon() {
        this.renderer = new ImageRenderer("resources/images/borua-pixilart (1).png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {

    }



}
