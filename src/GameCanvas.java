
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {

    private final int WIDTH = 1650;
    public final int HEIGHT = 1080;

    Anchor anchor;
    Player player;

    Graphics graphics;
    BufferedImage backBuffer;


    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);

        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = backBuffer.getGraphics();

        this.anchor = new Anchor();
        this.player = new Player();

        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new SmallObject());
        GameObjectManager.instance.add(new LargeObject());

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);

    }

    public void startCatching() {
        this.anchor.isCatching = true;
        this.anchor.isDropping = true;
        this.anchor.ropeDirection.set(anchor.position);
        this.anchor.movingDirection.set(this.anchor.position.subtractBy(this.player.getPosition()).normalize().multiply(3));
    }

    public void runAll() {
        this.anchor.run(this.player);
        GameObjectManager.instance.runAll();

    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.anchor.render(graphics);

        graphics.fillOval((int) player.getPosition().x - 3, (int)player.getPosition().y - 4, 7, 7);
        if (!anchor.isCatching) {
            graphics.drawLine( (int) player.getPosition().x, (int) player.getPosition().y, (int) anchor.position.x, (int) anchor.position.y);
        }

        else if (anchor.isCatching) {
            graphics.drawLine((int) player.getPosition().x, (int) player.getPosition().y,
                    (int) anchor.ropeDirection.x, (int) anchor.ropeDirection.y);
        }

//        graphics.fillOval((int) ballPosition.x - 7, (int) ballPosition.y - 7, 14, 14);
        this.repaint();
    }




}
