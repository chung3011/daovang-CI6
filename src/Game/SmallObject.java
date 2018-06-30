package Game;


import Base.GameObject;
import Base.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class SmallObject extends GameObject implements PhysicBody {

    BoxCollider boxCollider;
    Random random;

    public SmallObject() {
        random = new Random();
        this.position = new Vector2D(random.nextInt(1650), random.nextInt(1080));
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider( (int) this.position.x - 10, (int) this.position.y - 10);
    }

    public BoxCollider getBoxCollider() {
        return  this.boxCollider;

    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}

