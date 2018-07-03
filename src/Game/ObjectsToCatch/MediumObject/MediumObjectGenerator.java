package Game.ObjectsToCatch.MediumObject;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Level;
import Game.ObjectsToCatch.LargeObject.LargeObject;

import java.util.Random;

public class MediumObjectGenerator extends GameObject {
    private Random random;
    private int need;
    private Vector2D[] posLevel1 = {new Vector2D(320, 300)};

    public MediumObjectGenerator() {
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
                            MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
                            mediumObject.position.set(posLevel1[count++]);
                            mediumObject.boxCollider.position.set((int) mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
                            return true;
                        }
                    },
                    1)
            );
        }

    }

    @Override
    public void run() {
        super.run();
    }
}
