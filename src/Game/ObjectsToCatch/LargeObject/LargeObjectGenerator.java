package Game.ObjectsToCatch.LargeObject;

import Action.*;
import Base.GameObject;
import Base.GameObjectManager;
import Base.Vector2D;
import Constant.Constant;
import Game.Level;

import java.util.Random;

public class LargeObjectGenerator extends GameObject {

    private Random random;
    private int need;
    private Vector2D[] posLevel1 = { new Vector2D(950,200), new Vector2D(800,450),
                                        new Vector2D(120, 400)};


    public LargeObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
//        if (Level.level == 1) need = Constant.Level.largeLv1;
//        if (Level.level == 2) need = Constant.Level.largeLv2;
//        this.addAction(new LimitAction(
//                new ActionAdapter() {
//                    @Override
//                    public boolean run(GameObject owner) {
//                        LargeObject largeObject = GameObjectManager.instance.recycle(LargeObject.class);
//                        largeObject.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
//                        largeObject.boxCollider.position.set((int) largeObject.position.x - 20, (int) largeObject.position.y - 20);
//                        return true;
//                    }
//                },
//                need + random.nextInt(3)+1)
//        );priva
        if (Level.level == 1) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        int count = 0;
                        @Override
                        public boolean run(GameObject owner) {
                            LargeObject largeObject = GameObjectManager.instance.recycle(LargeObject.class);
                            largeObject.position.set(posLevel1[count++]);
                            largeObject.boxCollider.position.set((int) largeObject.position.x - 20, (int) largeObject.position.y - 20);
                            return true;
                        }
                    },
                    3)
            );
        }


    }

    //asdfsdf

    @Override
    public void run() {
        super.run();
    }

}
