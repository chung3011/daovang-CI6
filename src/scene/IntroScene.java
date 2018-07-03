package scene;

import Base.GameObjectManager;
import Game.Background.IntroBackGround;

public class IntroScene implements Scene{
    @Override
    public void init() {

        GameObjectManager.instance.recycle(IntroBackGround.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
//        System.out.println("start scene cleared");
    }
}
