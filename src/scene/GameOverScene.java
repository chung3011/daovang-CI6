package scene;

import Base.GameObjectManager;
import Game.Background.GameOverBackground;
import Game.Background.WhiteBackground;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(WhiteBackground.class);
        GameObjectManager.instance.add(new GameOverBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
