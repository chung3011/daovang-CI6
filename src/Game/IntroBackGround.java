package Game;

import Base.GameObject;
import Renderer.IntroBackGroundRenderer;

import java.awt.*;

public class IntroBackGround extends GameObject{
    public IntroBackGround() {
        this.renderer = new IntroBackGroundRenderer(1024, 600, Color.WHITE);
    }
}
