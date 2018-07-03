//package Input;
//
//import Constant.Constant;
//import Game.Level;
//import scene.*;
//
//public class ClickButtonReact {
//    public static ClickButtonReact instance = new ClickButtonReact();
//
//    public void run(String labelButton) {
//        if (labelButton.equals(Constant.Button.START)) {
//            if (SceneManager.instance.getCurrentScene() instanceof StartScene) {
//                SceneManager.instance.changeScene(new LevelOneScene());
//            } else if (SceneManager.instance.getCurrentScene() instanceof LevelOneScene) {
//                SceneManager.instance.changeScene(new GamePlayScene());
//            } else if (SceneManager.instance.getCurrentScene() instanceof LevelTwoScene) {
//                SceneManager.instance.changeScene(new GamePlayScene());
//            }
//        }
//
//        if (labelButton.equals(Constant.Button.REPLAY_ALL))  {
//            if (SceneManager.instance.getCurrentScene() instanceof GameOverScene) {
//                Level.level = 0;
//                SceneManager.instance.changeScene(new LevelOneScene());
//            }
//        }
//
//
//
//
//    }
//}
