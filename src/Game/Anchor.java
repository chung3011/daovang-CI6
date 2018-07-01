package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Physic.PhysicBody;
import Physic.BoxCollider;
import Physic.RunHitObject;
import Renderer.ImageRenderer;

public class Anchor extends GameObject implements PhysicBody {

    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 600;

    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final int STRING_LENGTH = 100;

    public BoxCollider boxCollider;

    public double angle;
    public double angleAccel = 0;
    public double angleVelocity = 0;
    public double dt = 0.1 ;

    public boolean isDropping = false;
    public boolean isCatching = false;

    public Vector2D playerPosition;
    public Vector2D ropeDirection;
    public Vector2D movingDirection;

    private RunHitObject runHitObject;

    public Anchor() {
        this.renderer = new ImageRenderer("resources/images/anchor.png", WIDTH,HEIGHT);
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(WIDTH,HEIGHT);
        this.playerPosition = new Vector2D();
        this.ropeDirection = new Vector2D();
        this.movingDirection = new Vector2D();
        this.runHitObject = new RunHitObject(
                LargeObject.class,
                MediumObject.class,
                SmallObject.class);

        this.angle = Math.PI / 2;
    }


    public void run() {
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.playerPosition.set(player.getPosition());
        }

        if (!isCatching) {
            this.angleAccel = -9.81 / STRING_LENGTH * Math.sin(this.angle );
            this.angleVelocity += this.angleAccel * dt;
            this.angle += this.angleVelocity * dt;
            this.position.set(this.playerPosition.x + (int) (Math.sin(this.angle) * STRING_LENGTH),
                    this.playerPosition.y + (int) (Math.cos(this.angle) * STRING_LENGTH));
        }

        if (isCatching) {
            if (ropeDirection.x > WINDOW_WIDTH || ropeDirection.y > WINDOW_HEIGHT || ropeDirection.x < 0) {
                isDropping = false;
            }

            if (isDropping) {
                ropeDirection.addUp(movingDirection);
                runHitObject.run(this);
            }

            if (!isDropping) {
//                if( (playerPosition.y -10 <= ropeDirection.y || ropeDirection.y <= playerPosition.y + 10) && (
//                        playerPosition.x-10 <= ropeDirection.x && ropeDirection.x <= playerPosition.x + 10) ) {
                if (ropeDirection.subtract(playerPosition).length() <= 10) {
                    isCatching = false;

                }
                else ropeDirection.subtractBy(movingDirection);
            }
            this.position.set(ropeDirection);

        }
        boxCollider.position.set( (int) this.position.x - 10, (int) this.position.y - 10 );
    }


    @Override
    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isDropping = false;

        if (gameObject instanceof LargeObject) {
            movingDirection.multiply(1.0f/3.0f);
        }

        else if (gameObject instanceof MediumObject) {
            movingDirection.multiply(1.0f/2.0f);
        }
    }


}
