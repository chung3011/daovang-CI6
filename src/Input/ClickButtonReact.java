package Input;

import Constant.Constant;
import scene.GamePlayScene;
import scene.IntroScene;
import scene.SceneManager;
import scene.StartScene;

public class ClickButtonReact {
    public static ClickButtonReact instance = new ClickButtonReact();
    public void run(String labelButton){
        if(labelButton.equals(Constant.Button.START))
            if (SceneManager.instance.getCurrentScene() instanceof StartScene) {
                SceneManager.instance.changeScene(new IntroScene());
            }
            else if (SceneManager.instance.getCurrentScene() instanceof IntroScene) {
                SceneManager.instance.changeScene(new GamePlayScene());
            }


    }
}
