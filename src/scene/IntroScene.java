package scene;

import Base.GameObjectManager;
import Game.Background.CharactersBackground;
import Game.Background.WhiteBackground;

public class IntroScene implements Scene{
    @Override
    public void init() {
        GameObjectManager.instance.recycle(WhiteBackground.class);
        GameObjectManager.instance.recycle(CharactersBackground.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
//        System.out.println("start scene cleared");
    }
}
