package Game.Effect;

import Base.GameObject;
import Base.GameObjectManager;
import Game.Anchor;
import Game.Level;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class ShieldEffect extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public ShieldEffect() {
        this.renderer = new ImageRenderer("resources/images/Objects/buomhong'-pixilart.png", 50, 50);
        this.boxCollider = new BoxCollider( 50,50 );
        this.isCaught = false;
        if (Level.level == 1) {
            this.isAlive = false;

//            this.position.set(600, 200);
        }
        if (Level.level == 2) {
            this.position.set(900, 320);
        }

        if (Level.level == 3) {
            this.position.set(339,500);
        }
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
