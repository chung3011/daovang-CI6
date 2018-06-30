package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

import java.util.Random;

public class LargeObject extends GameObject implements PhysicBody {

    BoxCollider boxCollider;
    Random random;
    boolean isCaught;

    public LargeObject() {
        random = new Random();
        this.renderer = new ImageRenderer("resources/images/circle.png", 40, 40);
        this.boxCollider = new BoxCollider( 40,40 );

        this.isCaught = false;
        this.isAlive = true;
    }

    @Override
    public void run() {
        if (isCaught) {
            Anchor anchor = GameObjectManager.instance.findAnchor();
            if (!anchor.isCatching) {
                this.isAlive = false;
            }
            else this.position.set(anchor.position);
        }

    }

    public void getHit() {
        this.isCaught = true;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }


}
