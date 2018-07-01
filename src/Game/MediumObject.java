package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class MediumObject extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public MediumObject() {
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

    @Override
    public void getHit(GameObject gameObject) {
        this.isCaught = true;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
