package Game.ObjectsToCatch.Leaves;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Level;

import java.util.Random;

public class LeavesGenerator extends GameObject{

    private Vector2D[] posLevel1 = { new Vector2D(150,250), new Vector2D(300,500),
                                     new Vector2D(510, 350), new Vector2D(650, 300),
                                     new Vector2D(950, 380)};
    private Vector2D[] posLevel2 = { new Vector2D(100,150), new Vector2D(250, 320),
                                    new Vector2D(800, 570), new Vector2D(250, 500),
                                    new Vector2D(450, 450), new Vector2D(700, 270)};

    public LeavesGenerator() {
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

        if (Level.level == 2) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            Leaves leaf = GameObjectManager.instance.recycle(Leaves.class);
                            leaf.position.set(posLevel2[count++]);
                            leaf.boxCollider.position.set((int) leaf.position.x - 20, (int) leaf.position.y - 20);
                            return true;
                        }
                    },
                    posLevel2.length)
            );
        }
    }

    //asdfsdf

    @Override
    public void run() {
        super.run();
    }

}
