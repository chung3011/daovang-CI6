package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background;
import Game.Button;
import Game.IntroBackGround;

public class IntroScene implements Scene {
    @Override
    public void init() {


        Button winningConditions = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2-50) ,
                300,
                300,
                "winningCondition","resources/images/dieu-kien-thang-1-pixilart.png"); // "Start Button"


        Button startButton = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2+200) ,
                300,
                80,
                Constant.Button.START,"resources/images/temp_start.png");

        GameObjectManager.instance.recycle(IntroBackGround.class);
        GameObjectManager.instance.add(winningConditions);
        GameObjectManager.instance.add(startButton);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
