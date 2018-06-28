
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {

    private final int WIDTH = 1650;
    public final int HEIGHT = 1080;

    Anchor anchor;
    Player player;
    LargeObject largeObject = new LargeObject();

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

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);

    }

    public void startCatching() {
        Anchor anchor = GameObjectManager.instance.findAnchor();
        anchor.isCatching = true;
        anchor.isDropping = true;
        anchor.ropeDirection.set(anchor.position);
        anchor.movingDirection.set(this.anchor.position.subtractBy(this.player.getPosition()).normalize().multiply(3));
    }

    public void runAll() {
        GameObjectManager.instance.runAll();

    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.anchor.render(graphics);
        this.largeObject.render(graphics);
        this.graphics.setColor(Color.WHITE);

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
