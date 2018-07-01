
import Base.GameObjectManager;
import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    private final int WIDTH = 1024;
    public final int HEIGHT = 600;

    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);

        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        this.graphics = backBuffer.getGraphics();

        GameObjectManager.instance.add(new Anchor());
        GameObjectManager.instance.add(new Player());
        GameObjectManager.instance.add(new Background());

//        GameObjectManager.instance.add(new SmallObject());
        GameObjectManager.instance.add(new LargeObjectGenerator());

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
        anchor.movingDirection.set(anchor.position.subtract(player.getPosition()).normalize().multiply(3));
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

}