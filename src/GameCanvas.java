
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private final int WIDTH = 1650;
    public final int HEIGHT = 1080;

    public Anchor anchor;
    public Player player;

    Vector2D ropeDirection;
    Vector2D movingDirection;


    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);

        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = backBuffer.getGraphics();

        this.anchor = new Anchor();
        this.player = new Player();

        this.ropeDirection = new Vector2D();
        this.movingDirection = new Vector2D();

        this.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);

    }

    public void runAll() {
        anchor.run(player.getPosition(), ropeDirection, movingDirection);
    }


    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void renderAll() {
        this.renderBackground();
        this.graphics.setColor(Color.WHITE);
        graphics.fillOval((int) player.getPosition().x - 3, (int)player.getPosition().y - 4, 7, 7);

        if (!anchor.isCatching) {
            graphics.drawLine( (int) player.getPosition().x, (int) player.getPosition().y, (int) anchor.position.x, (int) anchor.position.y);
        }

        else if (anchor.isCatching) {
            graphics.drawLine((int) player.getPosition().x, (int) player.getPosition().y, (int) ropeDirection.x, (int) ropeDirection.y);
        }
        this.anchor.render(graphics);


//        graphics.fillOval((int) ballPosition.x - 7, (int) ballPosition.y - 7, 14, 14);
        this.repaint();
    }



    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
