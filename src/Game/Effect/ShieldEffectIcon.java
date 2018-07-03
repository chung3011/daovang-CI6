package Game.Effect;

import Base.GameObject;
import Base.Vector2D;
import Renderer.ImageRenderer;
import scene.GameOverScene;

public class ShieldEffectIcon extends GameObject{
    public ShieldEffectIcon() {
        this.renderer = new ImageRenderer("resources/images/Objects/buomhong'-pixilart.png", 20, 20);
        this.position = new Vector2D();
    }

    @Override
    public void run() {

    }
}
