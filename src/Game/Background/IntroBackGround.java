package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.IntroBackGroundRenderer;

import java.awt.*;

public class IntroBackGround extends GameObject{
    public IntroBackGround() {
        this.renderer = new IntroBackGroundRenderer(Constant.Window.WIDTH, Constant.Window.HEIGHT, Color.WHITE);
    }
}
