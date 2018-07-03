package scene;


import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.CharactersBackground;
import Game.Background.StartGameBackground;
import Game.Background.WhiteBackground;
import Game.Button;

public class StartScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add( new WhiteBackground());
        GameObjectManager.instance.add(new StartGameBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        System.out.println("start scene cleared");
    }
}
