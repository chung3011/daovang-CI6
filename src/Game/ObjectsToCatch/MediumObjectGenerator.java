package Game.ObjectsToCatch;

import Action.ActionAdapter;
import Action.LimitAction;
import Action.SequenceAction;
import Action.WaitAction;
import Base.GameObject;
import Base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumObjectGenerator extends GameObject {
    private Random random;

    public MediumObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
//        this.addAction(
//                new SequenceAction(
//                        new ActionAdapter() {
//
//                            private List<MediumObject> list = new ArrayList<>();
//                            private int count = 0;
//
//                            @Override
//                            public boolean run(GameObject owner) {
//                                if (list.isEmpty()) {
//                                    MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
//                                    mediumObject.position.set(30 + random.nextInt(950),150 +  random.nextInt(200));
//                                    this.count += 1;
//                                    list.add(mediumObject);
//                                }
//
//                                list.removeIf(mediumObject -> !mediumObject.isAlive);
//
//                                return this.count == 5;
//                            }
//                        },
//                        new WaitAction(300)
//                )
//        );

        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        MediumObject mediumObject = GameObjectManager.instance.recycle(MediumObject.class);
                        mediumObject.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                        mediumObject.boxCollider.position.set((int) mediumObject.position.x - 20, (int) mediumObject.position.y - 20);
                        System.out.println(mediumObject.position.x + " " +  mediumObject.position.y);
                        return true;
                    }
                },
                4)
        );
    }

    @Override
    public void run() {
        super.run();
    }
}
