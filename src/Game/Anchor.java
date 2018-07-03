package Game;

import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Bomb.Bomb;
import Game.Cockcroach.Cockcroach;
import Game.Effect.ShieldEffect;
import Game.Effect.SpeedEffect;
import Game.ObjectsToCatch.LargeObject.LargeObject;
import Game.ObjectsToCatch.Leaves.Leaves;
import Game.ObjectsToCatch.MediumObject.MediumObject;
import Game.ObjectsToCatch.SmallObject.SmallObject;
import Physic.PhysicBody;
import Physic.BoxCollider;
import Physic.RunHitObject;
import Utils.Utils;
import scene.GameOverScene;
import scene.SceneManager;

import javax.sound.sampled.Clip;

public class Anchor extends GameObject implements PhysicBody {

    private final int WIDTH = 10;
    private final int HEIGHT = 10;
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


    private Clip dropSound;
    private Clip catchSound;
    private Clip pullSound;

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
                Leaves.class,
                Cockcroach.class);

        this.angle = Math.PI / 2;
        this.level = new Level();
        this.speed = 3;


        /// load 3 file audio
        this.dropSound = Utils.loadAudio("resources/audio/button-3-small.wav");
        this.catchSound = Utils.loadAudio("resources/audio/Cartoon sound effects ping 1.wav");
        this.pullSound = Utils.loadAudio("resources/audio/pull.wav");

    }


    public void run() {

        Player player = GameObjectManager.instance.findPlayer();

        if (player != null) {
            this.playerPosition.set(player.getPosition());
        }


        if (!isCatching) {

            // kéo về đến player dừng âm thanh kéo (nếu ko bắt được gì)
            this.pullSound.stop();


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

            // bắt đầu thả dây thì bắt đầu âm thanh, count = -1 lặp vô tận đến stop
            this.dropSound.loop(-1);
            this.dropSound.start();


            ropeDirection.addUp(movingDirection);
            runHitObject.run(this);
        }

        if (!isDropping) {
            if (ropeDirection.subtract(playerPosition).length() <= 10) {
                isCatching = false;

                // bắt ko đc kéo về đến player thì stop
                this.dropSound.stop();

                if (isBomb) {
                    System.out.println("GAME OVER");
                    SceneManager.instance.changeScene(new GameOverScene());
                }

            }
            else ropeDirection.subtractBy(movingDirection);
        }
        this.position.set(ropeDirection);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isDropping = false;

        //bắt được thì stop âm thanh drop
        this.dropSound.stop();

        // khởi động âm thanh pull
        this.pullSound.loop(-1);
        this.pullSound.start();


        if (gameObject instanceof LargeObject) {

            // mỗi khi bắt được 1 object thì khơi động âm thanh catch 1 lần (count = 0 là ko lặp)
            this.catchSound.loop(0);
            this.catchSound.start();

            movingDirection.multiply(1.0f/4.0f);
            level.addLargeObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addLargeObjectIcon());
        }

        else if (gameObject instanceof MediumObject) {

            this.catchSound.loop(0);
            this.catchSound.start();

            movingDirection.multiply(1.0f/2.0f);
            level.addMediumObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addMediumObjectIcon());
        }

        else if (gameObject instanceof SmallObject) {

            this.catchSound.loop(0);
            this.catchSound.start();

            level.addSmallObjects();
            GameObjectManager.instance.add(IconGenerator.instance.addSmallObjectIcon());
        }

        else if (gameObject instanceof Bomb) {

            this.catchSound.loop(0);
            this.catchSound.start();

            if (this.hasShield) {
                this.hasShield = false;
            }
            else if (!this.hasShield) {
                this.isBomb = true;
            }
        }

        else if (gameObject instanceof ShieldEffect) {

            this.catchSound.loop(0);
            this.catchSound.start();

            this.hasShield = true;
//            GameObjectManager.instance.add(IconGenerator.instance.addShieldIcon());
        }

        else if (gameObject instanceof  SpeedEffect) {

            this.catchSound.loop(0);
            this.catchSound.start();

            this.speed = 8;
//            GameObjectManager.instance.add(IconGenerator.instance.addSpeedIcon());
        }

        else if (gameObject instanceof Leaves) {
            this.catchSound.loop(0);
            this.catchSound.start();

            this.movingDirection.multiply(1.0f/4.0f);
            level.addLeaf();
            GameObjectManager.instance.add(IconGenerator.instance.addLeaf());
        }

        else if (gameObject instanceof Cockcroach) {
            this.catchSound.loop(0);
            this.catchSound.start();
            this.isBomb = true;

        }
    }


}
