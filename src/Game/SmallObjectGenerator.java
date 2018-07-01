package Game;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.Random;

public class SmallObjectGenerator extends GameObject {
    private FrameCounter frameCounter;
    private Random random;

    public SmallObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        SmallObject smallObject = GameObjectManager.instance.recycle(SmallObject.class);
                        smallObject.position.set(200 + random.nextInt(400),200 +  random.nextInt(200));
                        return true;
                    }
                },
                5)
        );
    }
    @Override
    public void run() {
        super.run();
    }
}
