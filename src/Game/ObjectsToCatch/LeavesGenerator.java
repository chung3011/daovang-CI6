package Game.ObjectsToCatch;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Constant.Constant;
import Game.Level;

import java.util.Random;

public class LeavesGenerator extends GameObject{
    private Random random;
    private int need;

    public LeavesGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        if (Level.level == 1) need = Constant.Level.largeLv1;
        if (Level.level == 2) need = Constant.Level.largeLv2;
        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        Leaves leaf = GameObjectManager.instance.recycle(Leaves.class);
                        leaf.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                        leaf.boxCollider.position.set((int) leaf.position.x - 20, (int) leaf.position.y - 20);
                        return true;
                    }
                },
                need + random.nextInt(3)+1)
        );
    }

    //asdfsdf

    @Override
    public void run() {
        super.run();
    }

}
