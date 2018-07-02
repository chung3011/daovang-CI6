
import Base.GameObjectManager;
import Game.*;
import Game.ObjectsToCatch.LargeObjectGenerator;
import Game.ObjectsToCatch.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObjectGenerator;
import Input.MouseInput;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.StartScene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    private final int WIDTH = 1024;
    public final int HEIGHT = 600;

    Graphics graphics;
    BufferedImage backBuffer;

    public GameCanvas() {
        this.setSize(WIDTH,HEIGHT);
        this.setUpBackBuffer();
        SceneManager.instance.changeScene(new StartScene());

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffer,0,0,null);
    }

    public void setUpBackBuffer() {
        this.backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        this.graphics = backBuffer.getGraphics();
    }

    public void startCatching() {
        Anchor anchor = GameObjectManager.instance.findAnchor();
        Player player = GameObjectManager.instance.findPlayer();
        anchor.isCatching = true;
        anchor.isDropping = true;
        anchor.ropeDirection.set(anchor.position);
        anchor.movingDirection.set(anchor.position.subtract(player.getPosition()).normalize().multiply(3));
    }

    public void runAll() {
        GameObjectManager.instance.runAll();

        if(MouseInput.instance.clicked){
            MouseInput.instance.checkMouseClicked();
            MouseInput.instance.clicked = false;
        }
        SceneManager.instance.performChangeSceneIfNeeded();
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

}