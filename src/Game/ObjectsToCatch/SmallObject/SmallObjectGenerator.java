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
    private Vector2D[] posLevel1 = { new Vector2D(600,500)};
    private Vector2D[] posLevel2 = { new Vector2D(300, 280), new Vector2D(450, 150),
                                    new Vector2D(630, 350), new Vector2D(700, 150)};

    private Vector2D[] posLevel3 = { new Vector2D(80, 150), new Vector2D(85, 360),
            new Vector2D(256, 510), new Vector2D(598, 490),
            new Vector2D(683, 290), new Vector2D(990, 370)};

    public SmallObjectGenerator() {
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

        else if (Level.level == 2) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            SmallObject smallObject = GameObjectManager.instance.recycle(SmallObject.class);
                            smallObject.position.set(posLevel2[count++]);
                            smallObject.boxCollider.position.set((int) smallObject.position.x - 20, (int) smallObject.position.y - 20);
                            return true;
                        }
                    },
                    posLevel2.length)
            );
        }

        else if (Level.level == 3) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            SmallObject smallObject = GameObjectManager.instance.recycle(SmallObject.class);
                            smallObject.position.set(posLevel3[count++]);
                            smallObject.boxCollider.position.set((int) smallObject.position.x - 20, (int) smallObject.position.y - 20);
                            return true;
                        }
                    },
                    posLevel3.length)
            );
        }

    }
    @Override
    public void run() {
        super.run();
    }
}
