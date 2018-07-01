package Game;

import Action.*;
import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LargeObjectGenerator extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public LargeObjectGenerator() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
        this.createAction();
    }

    public void createAction() {
        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        LargeObject largeObject = GameObjectManager.instance.recycle(LargeObject.class);
                        largeObject.position.set(30 + random.nextInt(950),400 +  random.nextInt(200));
                        largeObject.boxCollider.position.set((int) largeObject.position.x - 20, (int) largeObject.position.y - 20);
                        System.out.println(largeObject.position.x + " " + largeObject.position.y);
                        return true;
                    }
                },
                5)
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            LargeObject largeObject = new LargeObject();
//            largeObject.position.set(this.random.nextInt(1650), this.random.nextInt(1080));
//            largeObject.boxCollider.position.set((int)largeObject.position.x - 20, (int) largeObject.position.y - 20);
//            GameObjectManager.instance.add(largeObject);
//            this.frameCounter.reset();
//        }


    }

}
