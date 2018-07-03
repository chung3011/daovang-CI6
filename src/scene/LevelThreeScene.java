package scene;

import Base.GameObjectManager;
import Game.Background.LevelOneBackground;
import Game.Background.LevelThreeBackground;

public class LevelThreeScene implements Scene{
    public void init() {

        GameObjectManager.instance.add(new LevelThreeBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
