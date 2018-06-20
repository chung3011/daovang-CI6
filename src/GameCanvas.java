
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

    public double angleAccel = 0;
    public double angleVelocity = 0;
    public double dt = 0.1 ;

    public boolean isDropping = false;
    public boolean isCatching = false;
    Vector2D anchorPosition;
    Vector2D ballPosition;
    Vector2D ropeDirection;
    Vector2D movingDirection;

    BufferedImage ballImage;
    BufferedImage anchorImage;
    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);
        angle = Math.PI / 2;
        length = 100;
        anchorPosition = new Vector2D(WIDTH/3,HEIGHT/8);
        ballPosition = new Vector2D(anchorPosition.x + (int) (Math.sin(angle) * length), anchorPosition.y + (int) (Math.cos(angle) * length) );
        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = backBuffer.getGraphics();

        try {
            this.anchorImage = ImageIO.read(new File("resources/images/anchor.png"));
            this.ballImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.ropeDirection = new Vector2D();

        this.setVisible(true);
        this.movingDirection = new Vector2D();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);

    }

    public void runAll() {

        if (!isCatching) {
            angleAccel = -9.81 / this.length * Math.sin(this.angle );
            angleVelocity += angleAccel * dt;
            this.angle += angleVelocity * dt;
            ballPosition.set(anchorPosition.x + (int) (Math.sin(angle) * length), anchorPosition.y + (int) (Math.cos(angle) * length));
        }

        if (isCatching) {
            if (ropeDirection.x > WIDTH - 200|| ropeDirection.y > HEIGHT - 200 || ropeDirection.x < 200) {
                isDropping = false;
            }

            if (isDropping) {
                ropeDirection.addUp(movingDirection);
            }

            if (!isDropping) {
                if (ropeDirection.y <= anchorPosition.y + 100) {
                    isCatching = false;

                }
                else ropeDirection.subtractBy(movingDirection);



            }


        }

    }


    private void renderBackground() {
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void renderAll() {
        this.renderBackground();
        this.graphics.setColor(Color.BLACK);
        graphics.fillOval((int) anchorPosition.x - 3, (int)anchorPosition.y - 4, 7, 7);

        if (!isCatching) {
            graphics.drawLine( (int) anchorPosition.x, (int) anchorPosition.y, (int) ballPosition.x, (int) ballPosition.y);

            this.graphics.drawImage(this.anchorImage, (int) ballPosition.x - 7, (int) ballPosition.y - 7, 14, 14, null);

        }

        else if (isCatching) {

            graphics.drawLine((int) anchorPosition.x, (int) anchorPosition.y, (int) ropeDirection.x, (int) ropeDirection.y);
        }

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
