package Game.ObjectsToCatch.SmallObject;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.FrameCounter;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Level;
import Game.ObjectsToCatch.MediumObject.MediumObject;

import java.util.Random;

public class SmallObjectGenerator extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Vector2D[] posLevel1 = { new Vector2D(600,500)};
    private int need;

    public SmallObjectGenerator() {
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
                            SmallObject smallObject = GameObjectManager.instance.recycle(SmallObject.class);
                            smallObject.position.set(posLevel1[count++]);
                            smallObject.boxCollider.position.set((int) smallObject.position.x - 20, (int) smallObject.position.y - 20);
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
