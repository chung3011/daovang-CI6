package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class SpeedEffect extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public SpeedEffect() {
        this.renderer = new ImageRenderer("resources/images/buombuom-pixilart.png", 50, 50);
        this.boxCollider = new BoxCollider( 50,50 );
        this.position = new Vector2D(150, 150);
        this.isCaught = false;
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
