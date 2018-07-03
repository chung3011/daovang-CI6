package Game.Effect;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Anchor;
import Game.Level;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class SpeedEffect extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;

    public SpeedEffect() {
        this.renderer = new ImageRenderer("resources/images/Objects/buomdo'-pixilart (1).png", 50, 50);
        this.boxCollider = new BoxCollider( 50,50 );
        this.position = new Vector2D(150, 150);
        this.isCaught = false;
        if (Level.level == 1) {
//            this.isAlive = false;
            this.position.set(600, 200);

        }
        else if (Level.level == 2) {
            this.position.set(550,520);
        }
        else if (Level.level == 3) {
            this.position.set(171,380);
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
