import java.awt.*;

public class Anchor extends GameObject implements PhysicBody  {

    private final int WINDOW_WIDTH = 1650;
    private final int WINDOW_HEIGHT = 1080;

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


    public Anchor() {
        this.renderer = new ImageRenderer("resources/images/anchor.png", WIDTH,HEIGHT);
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(WIDTH,HEIGHT);
        this.playerPosition = new Vector2D();
        this.ropeDirection = new Vector2D();
        this.movingDirection = new Vector2D();

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
            if (ropeDirection.x > WINDOW_WIDTH - 200|| ropeDirection.y > WINDOW_HEIGHT - 200 || ropeDirection.x < 0) {
                isDropping = false;
            }

            if (isDropping) {
                ropeDirection.addUp(movingDirection);
            }

            if (!isDropping) {
                if( (playerPosition.y -10 <= ropeDirection.y || ropeDirection.y <= playerPosition.y + 10) && (
                        playerPosition.x-10 <= ropeDirection.x && ropeDirection.x <= playerPosition.x + 10) ) {
                    isCatching = false;

                }
                else ropeDirection.subtractBy(movingDirection);
            }
            this.position.set(ropeDirection);

        }
        boxCollider.position.set( (int) this.position.x - 10, (int) this.position.y - 10 );

        LargeObject largeObject = GameObjectManager.instance.checkCollision(this.boxCollider, LargeObject.class);
        if (largeObject != null) {
            largeObject.getHit();
            this.isDropping = false;
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

    @Override
    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }




}
