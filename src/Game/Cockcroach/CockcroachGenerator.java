package Game.Cockcroach;

import Action.ActionAdapter;
import Action.LimitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Game.Level;

public class CockcroachGenerator extends GameObject{
    private Vector2D[] posLevel1 = { new Vector2D(300,450) };
    private Vector2D[] posLevel2 = { new Vector2D(600, 470), new Vector2D(130, 200)};

    private Vector2D[] posLevel3 = { new Vector2D(424, 490), new Vector2D(900, 250),
            new Vector2D(160, 510)};

    public CockcroachGenerator() {
        this.createAction();
    }

    public void createAction() {

        if (Level.level == 1) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            Cockcroach cockcroach = GameObjectManager.instance.recycle(Cockcroach.class);
                            cockcroach.position.set(posLevel1[count++]);
                            return true;
                        }
                    },
                    posLevel1.length)
            );
        }

        else if (Level.level == 2) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            Cockcroach cockcroach = GameObjectManager.instance.recycle(Cockcroach.class);
                            cockcroach.position.set(posLevel2[count++]);
                            cockcroach.boxCollider.position.set((int) cockcroach.position.x - 20, (int) cockcroach.position.y - 20);
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
                            Cockcroach cockcroach = GameObjectManager.instance.recycle(Cockcroach.class);
                            cockcroach.position.set(posLevel3[count++]);
                            cockcroach.boxCollider.position.set((int) cockcroach.position.x - 20, (int) cockcroach.position.y - 20);
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
