package Game;

import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import java.util.Random;

public class LargeObjectGenerator extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public LargeObjectGenerator() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            LargeObject largeObject = new LargeObject();
            largeObject.position.set(this.random.nextInt(1650), this.random.nextInt(1080));
            largeObject.boxCollider.position.set((int)largeObject.position.x - 20, (int) largeObject.position.y - 20);
            GameObjectManager.instance.add(largeObject);
            this.frameCounter.reset();
        }
    }
}
