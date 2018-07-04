import Base.Vector2D;
import Constant.Constant;
import Game.Background.GameOverAnNhieu;
import Game.IconGenerator;
import Game.Level;
import scene.*;

import javax.swing.*;
import java.awt.event.*;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(Constant.Window.WIDTH , Constant.Window.HEIGHT);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.event();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
//        this.mouseEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (SceneManager.instance.getCurrentScene() instanceof GamePlayScene) {
                        gameCanvas.startCatching();
                    }
                    else if (SceneManager.instance.getCurrentScene() instanceof StartScene) {
                        SceneManager.instance.changeScene(new StoryScene());
                    }

                    else if (SceneManager.instance.getCurrentScene() instanceof StoryScene) {
                        SceneManager.instance.changeScene(new IntroScene());
                    }

                    else if (SceneManager.instance.getCurrentScene() instanceof IntroScene) {
                        SceneManager.instance.changeScene(new LevelOneScene());
                    }
                    else if (SceneManager.instance.getCurrentScene() instanceof LevelOneScene) {
                        SceneManager.instance.changeScene(new GamePlayScene());
                    }
                    else if (SceneManager.instance.getCurrentScene() instanceof LevelTwoScene) {
                        SceneManager.instance.changeScene(new GamePlayScene());
                    }

                    else if (SceneManager.instance.getCurrentScene() instanceof LevelThreeScene) {
                        SceneManager.instance.changeScene(new GamePlayScene());
                    }
                    else if (SceneManager.instance.getCurrentScene() instanceof GameOverScene ||
                            SceneManager.instance.getCurrentScene() instanceof WinningScene
                            || SceneManager.instance.getCurrentScene() instanceof GameOverAnNhieuScene) {
                        Level.level = 0;
                        IconGenerator.instance.resetVerticalPos();
                        SceneManager.instance.changeScene(new StartScene());
                    }


                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                }

            }
        });
    }


    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();

            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }

    }
}
