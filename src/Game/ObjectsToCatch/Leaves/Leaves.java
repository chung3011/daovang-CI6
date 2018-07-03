package Game.ObjectsToCatch.Leaves;

import Base.GameObject;
import Base.GameObjectManager;
import Game.Anchor;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class Leaves extends GameObject implements PhysicBody{
    public BoxCollider boxCollider;
    private boolean isCaught;

    public Leaves() {
        this.renderer = new ImageRenderer("resources/images/Objects/lado'-pixilart.png", 65, 65);
        this.boxCollider = new BoxCollider( 65,65 );
        this.isCaught = false;
    }

    @Override
    public void run() {
        this.boxCollider.position.set((int) this.position.x - 32, (int) this.position.y - 32);
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
