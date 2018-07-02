package Input;

import Constant.Constant;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.StartScene;

public class ClickButtonReact {
    public static ClickButtonReact instance = new ClickButtonReact();
    public void run(String labelButton){
        if(labelButton.equals(Constant.Button.START))
        {
            SceneManager.instance.changeScene(new GamePlayScene());
            System.out.println("start");
        }


    }
}
