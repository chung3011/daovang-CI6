package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.WhiteBackgroundRenderer;

import java.awt.*;

public class WhiteBackground extends GameObject{
    public WhiteBackground() {
        this.renderer = new WhiteBackgroundRenderer(Constant.Window.WIDTH, Constant.Window.HEIGHT, Color.WHITE);
    }
}
