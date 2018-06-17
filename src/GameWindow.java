import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(1650, 1080);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.windowEvent();
        this.setVisible(true);
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

                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;


//            try {
//                Thread.sleep(1);
//                this.gameCanvas.runAll();
//                this.gameCanvas.renderAll();
//                this.lastTime = currentTime;
//            } catch (InterruptedException ex) {}
        }
    }
}
