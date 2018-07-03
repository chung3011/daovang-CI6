package Game.Bomb;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Anchor;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

import java.util.Random;

public class Bomb extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private boolean isCaught;
    public Vector2D velocity;
    private Random random;

    private int WINDOW_WIDTH = Constant.Window.WIDTH;
    private int WINDOW_HEIGHT = Constant.Window.HEIGHT;

    public Bomb() {
        this.renderer = new ImageRenderer("resources/images/Objects/demen-pixilart.png", 26, 26);
        this.boxCollider = new BoxCollider( 26,26 );
        this.isCaught = false;
        this.velocity = new Vector2D();
        this.random = new Random();
    }

    @Override
    public void run() {
        this.position.addUp(this.velocity);
        this.boxCollider.position.set((int) this.position.x - 13, (int) this.position.y - 13);

        if (isCaught) {
            Anchor anchor = GameObjectManager.instance.findAnchor();
            if (!anchor.isCatching) {
                this.isAlive = false;
                this.isCaught = false;
            }
            else this.position.set(anchor.position);
        }
        this.backToScreen();
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isCaught = true;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    private void backToScreen() {
        if (this.position.x > WINDOW_WIDTH) {
            this.position.set(3, this.random.nextInt(WINDOW_HEIGHT)+150);
        }
        if (this.position.x < 0) {
            this.position.set(WINDOW_WIDTH, this.random.nextInt(WINDOW_HEIGHT) + 150);
        }

    }

}
