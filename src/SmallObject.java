import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SmallObject {

    Vector2D position;
    BoxCollider boxCollider;
    ImageRenderer renderer;
    Random random;


    public SmallObject() {
        random = new Random();
        this.position = new Vector2D(random.nextInt(1650), random.nextInt(1080));
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.GREEN);
        this.boxCollider = new BoxCollider( (int) this.position.x - 10, (int) this.position.y - 10);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

    public BoxCollider getBoxCollider() {
        return  this.boxCollider;

    }
}

