package Game;

import Action.ActionAdapter;
import Action.SequenceAction;
import Action.WaitAction;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BombGenerator extends GameObject {
    private Random random;

    public BombGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        this.addAction(
                new SequenceAction(
                        new WaitAction(5),
                        new ActionAdapter() {

                            private List<Bomb> list = new ArrayList<>();
                            private int count = 0;

                            @Override
                            public boolean run(GameObject owner) {
                                if (list.isEmpty()) {
                                    Bomb bom = GameObjectManager.instance.recycle(Bomb.class);
                                    bom.position.set(30 + random.nextInt(950),100 +  random.nextInt(200));
                                    this.count += 1;
                                    list.add(bom);
                                }

                                list.removeIf(mediumObject -> !mediumObject.isAlive);

                                return this.count == 15;
                            }
                        }
                )
        );
    }

    @Override
    public void run() {
        super.run();
    }
}
