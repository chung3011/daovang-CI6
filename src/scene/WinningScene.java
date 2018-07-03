package scene;

import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.IntroBackGround;
import Game.Button;

public class WinningScene implements Scene {
    @Override
    public void init() {
        Button gameOver = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2-50) ,
                500,
                200,
                "gameOver","resources/images/gameover-pixilart.png"); // "Game Over"


        Button replay = new Button(
                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2+200) ,
                300,
                80,
                Constant.Button.REPLAY_ALL,"resources/images/temp_start.png"); // "Start Button"

        GameObjectManager.instance.add(new IntroBackGround());
        GameObjectManager.instance.add(gameOver);
        GameObjectManager.instance.add(replay);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
