package Game.ObjectsToCatch;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Level;
import Game.ObjectsToCatch.SmallObject.SmallObject;

import java.util.Random;

public class LeavesGenerator extends GameObject{
    private Random random;
    private int need;
    private Vector2D[] posLevel1 = { new Vector2D(150,250), new Vector2D(300,500),
                                     new Vector2D(510, 350), new Vector2D(650, 300),
                                     new Vector2D(950, 380)};

    public LeavesGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        if (Level.level == 1) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            Leaves leaf = GameObjectManager.instance.recycle(Leaves.class);
                            leaf.position.set(posLevel1[count++]);
                            leaf.boxCollider.position.set((int) leaf.position.x - 20, (int) leaf.position.y - 20);
                            return true;
                        }
                    },
                    5)
            );
        }
    }

    //asdfsdf

    @Override
    public void run() {
        super.run();
    }

}
