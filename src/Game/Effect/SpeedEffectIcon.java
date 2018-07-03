package Game.Effect;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;

public class SpeedEffectIcon extends GameObject {
    public SpeedEffectIcon() {
        this.renderer = new ImageRenderer("resources/images/Objects/buomdo'-pixilart (1).png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {

    }
}
