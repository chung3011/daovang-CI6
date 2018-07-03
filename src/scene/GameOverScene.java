package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.Background;
import Game.Background.GameOverBackground;
import Game.Background.IntroBackGround;
import Game.Button;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add(new GameOverBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
