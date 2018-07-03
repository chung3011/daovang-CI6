package Game.Cockcroach;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class CockcroachIcon extends GameObject {
    public CockcroachIcon() {
        this.renderer = new ImageRenderer("resources/images/Objects/con-gian-pixilart.png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {

    }

}
