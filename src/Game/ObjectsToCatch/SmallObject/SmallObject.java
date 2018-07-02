package Game.ObjectsToCatch.SmallObject;


import Base.GameObject;
import Base.GameObjectManager;
import Game.Anchor;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;


public class SmallObject extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private boolean isCaught;

    public SmallObject() {
        this.renderer = new ImageRenderer("resources/images/Objects/ongmat-pixilart.png", 25, 25);
        this.boxCollider = new BoxCollider( 20,20 );
        this.isCaught = false;
    }

    @Override
    public void run() {
        this.boxCollider.position.set((int) this.position.x - 10, (int) this.position.y - 10);
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

