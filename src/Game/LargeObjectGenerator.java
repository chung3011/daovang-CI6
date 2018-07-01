package Game;

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
<<<<<<< HEAD
                        largeObject.position.set(30 + random.nextInt(950),400 +  random.nextInt(200));
=======
                        largeObject.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                        largeObject.boxCollider.position.set((int) largeObject.position.x - 20, (int) largeObject.position.y - 20);
>>>>>>> 85ac4d6742c3a75572e7b4f62eb629bcb5b0eeb3
                        System.out.println(largeObject.position.x + " " + largeObject.position.y);
                        return true;
                    }
                },
                3)
        );
    }

    @Override
    public void run() {
        super.run();
    }

}
