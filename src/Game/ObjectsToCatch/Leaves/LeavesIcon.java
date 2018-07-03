package Game.ObjectsToCatch.Leaves;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class LeavesIcon extends GameObject {
    public LeavesIcon() {
        this.renderer = new ImageRenderer("resources/images/Objects/leaf.png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {
    }
}
