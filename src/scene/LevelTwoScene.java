package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.IntroBackGround;
import Game.Button;

public class LevelTwoScene implements Scene {
    @Override
    public void init() {


        Button winningConditions = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2-50) ,
                300,
                300,
                "winningCondition","resources/images/LevelTwo/dieu-kien-thang-2-pixilart (1).png"); // "Start Button"


        Button conditionsWording = new Button(
                new Vector2D(200, Constant.Window.HEIGHT/2),
                300,
                300,
                "conditionsWording", "resources/images/winning-condition-pixilart.png");

        Button startButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2+200) ,
                300,
                80,
                Constant.Button.START,"resources/images/temp_start.png");

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
