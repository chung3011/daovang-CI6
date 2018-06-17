
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private final int WIDTH = 1650;
    public final int HEIGHT = 1080;

    public double angle;
    public int length;

    Vector2D anchorPosition;
    Vector2D ballPosition;

    BufferedImage ballImage;
    BufferedImage anchorImage;
    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(1650,1080);
        angle = Math.PI / 2;
        length = 100;
        anchorPosition = new Vector2D(WIDTH/2,HEIGHT/8);
        ballPosition = new Vector2D(anchorPosition.x + (int) (Math.sin(angle) * length), anchorPosition.y + (int) (Math.cos(angle) * length) );
        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = backBuffer.getGraphics();

        try {
            this.anchorImage = ImageIO.read(new File("resources/images/anchor.png"));
            this.ballImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);
    }

    public void runAll() {
        double angleAccel, angleVelocity = 0, dt = 0.1;
        angleAccel = -9.81 / this.length * Math.sin(this.angle );
        angleVelocity += angleAccel * dt;
        this.angle += angleVelocity * dt;
        ballPosition.set(anchorPosition.x + (int) (Math.sin(angle) * length), anchorPosition.y + (int) (Math.cos(angle) * length));

    }


    private void renderBackground() {
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void renderAll() {
        this.renderBackground();
        this.graphics.setColor(Color.BLACK);
//        graphics.drawLine( (int) anchorPosition.x, (int) anchorPosition.y, (int) ballPosition.x, (int) ballPosition.y);
        graphics.fillOval((int) anchorPosition.x - 3, (int)anchorPosition.y - 4, 7, 7);
        graphics.fillOval((int) ballPosition.x - 7, (int) ballPosition.y - 7, 14, 14);
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
