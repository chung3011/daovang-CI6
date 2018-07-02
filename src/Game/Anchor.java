package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Bomb.Bomb;
import Game.Effect.ShieldEffect;
import Game.Effect.SpeedEffect;
import Game.ObjectsToCatch.LargeObject.LargeObject;
import Game.ObjectsToCatch.Leaves;
import Game.ObjectsToCatch.MediumObject.MediumObject;
import Game.ObjectsToCatch.SmallObject.SmallObject;
import Physic.PhysicBody;
import Physic.BoxCollider;
import Physic.RunHitObject;

public class Anchor extends GameObject implements PhysicBody {

    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final int STRING_LENGTH = 100;

    public float speed;

    public double angle;
    public double angleAccel = 0;
    public double angleVelocity = 0;
    public double dt = 0.1 ;

    public boolean isDropping = false;
    public boolean isCatching = false;
    private boolean isBomb = false;
    private boolean hasShield = false;

    public Vector2D playerPosition;
    public Vector2D ropeDirection;
    public Vector2D movingDirection;

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Level level;

    public Anchor() {
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(WIDTH,HEIGHT);
        this.playerPosition = new Vector2D();
        this.ropeDirection = new Vector2D();
        this.movingDirection = new Vector2D();
        this.runHitObject = new RunHitObject(
                LargeObject.class,
                MediumObject.class,
                SmallObject.class,
                Bomb.class,
                ShieldEffect.class,
                SpeedEffect.class,
                Leaves.class);

        this.angle = Math.PI / 2;
        this.level = new Level();
        this.speed = 3;

    }


    public void run() {

        Player player = GameObjectManager.instance.findPlayer();

        if (player != null) {
            this.playerPosition.set(player.getPosition());
        }


        if (!isCatching) {
            this.rotateAnchor();
            this.level.isCompleted();
        }

        if (isCatching) {
            this.setCatching();
        }

        this.boxCollider.position.set( (int) this.position.x - 10, (int) this.position.y - 10 );
    }


    @Override
    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }


    private void rotateAnchor() {
        this.angleAccel = -9.81 / STRING_LENGTH * Math.sin(this.angle );
        this.angleVelocity += this.angleAccel * dt;
        this.angle += this.angleVelocity * dt;
        this.position.set(this.playerPosition.x + (int) (Math.sin(this.angle) * STRING_LENGTH),
                this.playerPosition.y + (int) (Math.cos(this.angle) * STRING_LENGTH));
    }

    private void setCatching() {
        if (ropeDirection.x > Constant.Window.WIDTH - 10 ||
                ropeDirection.y > Constant.Window.HEIGHT -10 || ropeDirection.x < 0) {
            isDropping = false;
        }

        if (isDropping) {
            ropeDirection.addUp(movingDirection);
            runHitObject.run(this);
        }

        if (!isDropping) {
            if (ropeDirection.subtract(playerPosition).length() <= 10) {
                isCatching = false;
                if (isBomb) {
                    System.out.println("GAME OVER");
                    System.exit(1);
                }
                if (this.speed == 1.5f) {
                    this.speed = 3f;
                }

            }
            else ropeDirection.subtractBy(movingDirection);
        }
        this.position.set(ropeDirection);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isDropping = false;

        if (gameObject instanceof LargeObject) {
            movingDirection.multiply(1.0f/4.0f);
            level.addLargeObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addLargeObjectIcon());
        }

        else if (gameObject instanceof MediumObject) {
            movingDirection.multiply(1.0f/2.0f);
            level.addMediumObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addMediumObjectIcon());
        }

        else if (gameObject instanceof SmallObject) {
            level.addSmallObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addSmallObjectIcon());
        }

        else if (gameObject instanceof Bomb) {
            if (this.hasShield) {
                this.hasShield = false;
            }
            else if (!this.hasShield) {
                this.isBomb = true;
            }
        }

        else if (gameObject instanceof ShieldEffect) {
            this.hasShield = true;
        }

        else if (gameObject instanceof  SpeedEffect) {
            this.speed = 8;
        }

        else if (gameObject instanceof Leaves) {
            this.movingDirection.multiply(1.0f/4.0f);
        }
    }


}
