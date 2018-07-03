package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Button;
import Game.Background.IntroBackGround;

public class LevelOneScene implements Scene {
    @Override
    public void init() {


        Button winningConditions = new Button(
                new Vector2D(650, Constant.Window.HEIGHT/2-100) ,
                300,
                300,
                "winningCondition","resources/images/LevelOne/dieu-kien-thang-1-pixilart.png"); // "Start Button"


        Button conditionsWording = new Button(
                new Vector2D(350, Constant.Window.HEIGHT/2 - 50),
                300,
                300,
                "conditionsWording", "resources/images/winning-condition-pixilart.png");

        Button startButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2 + 150) ,
                200,
                200,
                Constant.Button.START,"resources/images/pressspacetostart-pixilart.png");

        GameObjectManager.instance.recycle(IntroBackGround.class);
        GameObjectManager.instance.add(winningConditions);
        GameObjectManager.instance.add(startButton);
        GameObjectManager.instance.add(conditionsWording);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
