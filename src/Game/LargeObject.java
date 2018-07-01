package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;


public class LargeObject extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private boolean isCaught;

    public LargeObject() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 60, 60);
        this.boxCollider = new BoxCollider( 60,60 );

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

    @Override
    public void getHit(GameObject gameObject) {
        this.isCaught = true;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}