package scene;

import Base.GameObjectManager;
import Game.Background.LevelOneBackground;
import Game.Background.WhiteBackground;

public class LevelOneScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(WhiteBackground.class);
        GameObjectManager.instance.recycle(LevelOneBackground.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
