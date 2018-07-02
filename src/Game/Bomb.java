package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class Bomb extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public Bomb() {
        this.renderer = new ImageRenderer("resources/images/con-gian-pixilart.png", 26, 26);
        this.boxCollider = new BoxCollider( 26,26 );
        this.isCaught = false;
    }

    @Override
    public void run() {
        this.boxCollider.position.set((int) this.position.x - 13, (int) this.position.y - 13);
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
