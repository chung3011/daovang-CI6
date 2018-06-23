import java.awt.*;

public class Anchor {

    private final int WINDOW_WIDTH = 1650;
    private final int WINDOW_HEIGHT = 1080;

    private final int WIDTH = 20;
    private final int HEIGHT = 20;

    public ImageRenderer renderer;
    public Vector2D position;
    public BoxCollider boxCollider;
    public Player player;

    public double angle;
    public double stringLength;
    public double angleAccel = 0;
    public double angleVelocity = 0;
    public double dt = 0.1 ;

    public boolean isDropping = false;
    public boolean isCatching = false;


    public Anchor() {
        this.renderer = new ImageRenderer("resources/images/anchor.png", WIDTH,HEIGHT, Color.WHITE);
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider( (int) this.position.x - 10, (int) this.position.y - 10);
        this.player = new Player();

        this.angle = Math.PI / 2;
        this.stringLength = 100;
    }

    public void run(Vector2D playerPosition, Vector2D ropeDirection, Vector2D movingDirection ) {
        if (!isCatching) {
            angleAccel = -9.81 / this.stringLength * Math.sin(this.angle );
            angleVelocity += angleAccel * dt;
            this.angle += angleVelocity * dt;
            this.position.set(playerPosition.x + (int) (Math.sin(angle) * this.stringLength),
                    playerPosition.y + (int) (Math.cos(angle) * this.stringLength));
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
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }




}
