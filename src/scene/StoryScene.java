package scene;

import Base.GameObjectManager;
import Game.Background.StoryBackground;
import Game.Background.WhiteBackground;

public class StoryScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add( new WhiteBackground());
        GameObjectManager.instance.add(new StoryBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
