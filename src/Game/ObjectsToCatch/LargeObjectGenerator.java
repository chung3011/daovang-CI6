package Game.ObjectsToCatch;

import Action.*;
import Base.GameObject;
import Base.GameObjectManager;
import java.util.Random;

public class LargeObjectGenerator extends GameObject {

    private Random random;

    public LargeObjectGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        this.addAction(new LimitAction(
                new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        LargeObject largeObject = GameObjectManager.instance.recycle(LargeObject.class);
                        largeObject.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                        largeObject.boxCollider.position.set((int) largeObject.position.x - 20, (int) largeObject.position.y - 20);
                        System.out.println(largeObject.position.x + " " + largeObject.position.y);
                        return true;
                    }
                },
                4)
        );
    }

    //asdfsdf

    @Override
    public void run() {
        super.run();
    }

}
