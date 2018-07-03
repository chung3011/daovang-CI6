package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.WhiteBackground;
import Game.Background.WinningBackground;
import Game.Button;

public class WinningScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(WhiteBackground.class);
        GameObjectManager.instance.recycle(WinningBackground.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
