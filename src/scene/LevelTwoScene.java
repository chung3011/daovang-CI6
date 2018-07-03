package scene;

import Base.GameObjectManager;
import Game.Background.WhiteBackground;
import Game.Background.LevelTwoBackground;

public class LevelTwoScene implements Scene {
    public void init() {
        GameObjectManager.instance.recycle(WhiteBackground.class);
        GameObjectManager.instance.recycle(LevelTwoBackground.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
