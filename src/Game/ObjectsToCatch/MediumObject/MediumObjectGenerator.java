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
    private Vector2D[] posLevel1 = { new Vector2D(320, 300) };
    private Vector2D[] posLevel2 = { new Vector2D(140, 500), new Vector2D(250, 220),
                                    new Vector2D(500, 250), new Vector2D(700, 490),
                                    new Vector2D(800, 350)};

    private Vector2D[] posLevel3 = {new Vector2D(256, 330),new Vector2D(512, 460),
            new Vector2D(813, 490) };
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

        else if (Level.level == 2) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;

                        @Override
                        public boolean run(GameObject owner) {
                            MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
                            mediumObject.position.set(posLevel2[count++]);
                            mediumObject.boxCollider.position.set((int) mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
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
                            MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
                            mediumObject.position.set(posLevel3[count++]);
                            mediumObject.boxCollider.position.set((int) mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
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
