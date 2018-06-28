
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private final int WIDTH = 1650;
    public final int HEIGHT = 1080;



    Vector2D ropeDirection;
    Vector2D movingDirection;


    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);

        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = backBuffer.getGraphics();

        GameObjectManager.instance.add(new Anchor());
        GameObjectManager.instance.add(new Player());
        GameObjectManager.instance.add(new Background());

        GameObjectManager.instance.add(new SmallObject());
        GameObjectManager.instance.add(new LargeObject());

        this.ropeDirection = new Vector2D();
        this.movingDirection = new Vector2D();


        this.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);

    }

    public void startCatching() {
        Anchor anchor = GameObjectManager.instance.findAnchor();
        Player player = GameObjectManager.instance.findPlayer();
        anchor.isCatching = true;
        anchor.isDropping = true;
        anchor.ropeDirection.set(anchor.position);
        anchor.movingDirection.set(anchor.position.subtractBy(player.getPosition()).normalize().multiply(3));
    }

    public void runAll() {
        GameObjectManager.instance.runAll();

    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);




//        graphics.fillOval((int) ballPosition.x - 7, (int) ballPosition.y - 7, 14, 14);
        this.repaint();
    }




}
