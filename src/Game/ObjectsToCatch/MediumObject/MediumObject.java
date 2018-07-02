package Game.ObjectsToCatch.MediumObject;

import Base.GameObject;
import Base.GameObjectManager;
import Game.Anchor;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class MediumObject extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public MediumObject() {
        this.renderer = new ImageRenderer("resources/images/Objects/chuonchuon-pixilart.png", 40, 40);
        this.boxCollider = new BoxCollider( 35,35 );
        this.isCaught = false;
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set((int) this.position.x - 20, (int) this.position.y - 20);
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
