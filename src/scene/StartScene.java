package scene;


import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Background.CharactersBackground;
import Game.Button;

public class StartScene implements Scene {
    @Override
    public void init() {
//        Button intro = new Button(
//                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2-50) ,
//                500,
//                200,
//                "intro","resources/images/temp_intro.jpg"); // "Start Button"
//

//        Button startButton = new Button(
//                new Vector2D(Constant.Window.WIDTH/2, Constant.Window.HEIGHT/2+200) ,
//                300,
//                80,
//                Constant.Button.START,"resources/images/pressspacetostart-pixilart.png"); // "Start Button"

//        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new CharactersBackground());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        System.out.println("start scene cleared");
    }
}
