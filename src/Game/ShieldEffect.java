package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class ShieldEffect extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public ShieldEffect() {
        this.renderer = new ImageRenderer("resources/images/demen-pixilart.png", 50, 50);
        this.boxCollider = new BoxCollider( 50,50 );
        this.isCaught = false;
        this.position.set(500,150);
    }

    @Override
    public void run() {
        this.boxCollider.position.set((int) this.position.x - 25, (int) this.position.y - 25);
        if (isCaught) {
            Anchor anchor = GameObjectManager.instance.findAnchor();
            if (!anchor.isCatching) {
                this.isAlive = false;
                this.isCaught = false;
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
