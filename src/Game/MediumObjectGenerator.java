package Game;

import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.Random;

public class MediumObjectGenerator extends GameObject {
    private FrameCounter frameCounter;
    private Random random;

    public MediumObjectGenerator() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            MediumObject mediumObject = new MediumObject();
            mediumObject.position.set(this.random.nextInt(1650), this.random.nextInt(1080));
            mediumObject.boxCollider.position.set((int)mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
            GameObjectManager.instance.add(mediumObject);
            this.frameCounter.reset();
        }
    }
}
