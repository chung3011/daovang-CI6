package Game.ObjectsToCatch.SmallObject;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import Constant.Constant;
import Game.Level;

import java.util.Random;

public class SmallObjectGenerator extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private int need;

    public SmallObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {

        if (Level.level == 1) need = Constant.Level.smallLv1;
        if (Level.level == 2) need = Constant.Level.smallLv2;

        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        SmallObject smallObject = GameObjectManager.instance.recycle(SmallObject.class);
                        smallObject.position.set(200 + random.nextInt(400),200 +  random.nextInt(200));
                        return true;
                    }
                },
                need + random.nextInt(3)+1)
        );
    }
    @Override
    public void run() {
        super.run();
    }
}
