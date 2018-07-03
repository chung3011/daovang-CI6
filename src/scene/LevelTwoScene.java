package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.IntroBackGround;
import Game.Background.LevelTwoBackground;
import Game.Button;
import Game.Level;

public class LevelTwoScene implements Scene {
    public void init() {
        GameObjectManager.instance.recycle(IntroBackGround.class);
        GameObjectManager.instance.recycle(LevelTwoBackground.class);
        System.out.println(Level.level);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
