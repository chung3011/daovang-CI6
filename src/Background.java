import java.awt.*;

public class Background extends GameObject {
    public Vector2D position;
    public Renderer renderer;


    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(1650, 1080, Color.BLACK);
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}