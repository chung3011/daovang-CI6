package Game;

import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.Random;

public class SmallObjectGenerator extends GameObject {
    private FrameCounter frameCounter;
    private Random random;

    public SmallObjectGenerator() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            SmallObject smallObject = new SmallObject();
            smallObject.position.set(this.random.nextInt(1650), this.random.nextInt(1080));
            smallObject.boxCollider.position.set((int)smallObject.position.x - 20, (int) smallObject.position.y - 20);
            GameObjectManager.instance.add(smallObject);
            this.frameCounter.reset();
        }
    }
}
