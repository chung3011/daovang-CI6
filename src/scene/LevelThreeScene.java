package scene;

import Base.GameObjectManager;
import Game.Background.WhiteBackground;
import Game.Background.LevelThreeBackground;

public class LevelThreeScene implements Scene{
    public void init() {
        GameObjectManager.instance.add(new WhiteBackground());
        GameObjectManager.instance.add(new LevelThreeBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
