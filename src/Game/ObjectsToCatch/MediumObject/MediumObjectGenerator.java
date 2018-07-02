package Game.ObjectsToCatch.MediumObject;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Constant.Constant;
import Game.Level;

import java.util.Random;

public class MediumObjectGenerator extends GameObject {
    private Random random;
    private int need;

    public MediumObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        if (Level.level == 1) need = Constant.Level.mediumLv1;
        if (Level.level == 2) need = Constant.Level.mediumLv2;
        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
                        mediumObject.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                        mediumObject.boxCollider.position.set((int) mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
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
