import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.renderer = new BackgroundRenderer(1650, 1080, Color.BLACK);
    }


}