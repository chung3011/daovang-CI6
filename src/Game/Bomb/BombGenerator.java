package Game.Bomb;

import Action.ActionAdapter;
import Action.LimitAction;
import Action.SequenceAction;
import Action.WaitAction;
import Base.GameObject;
import Base.GameObjectManager;
import Constant.Constant;
import Game.Level;
import Game.ObjectsToCatch.LargeObject.LargeObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;

public class BombGenerator extends GameObject {
    private Random random;

    public BombGenerator() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction() {
        if (Level.level == 1) {
            this.addAction(
                    new ActionAdapter() {
                        @Override
                        public boolean run(GameObject owner) {
                            Bomb bomb = GameObjectManager.instance.recycle(Bomb.class);
//                            bomb.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                            bomb.position.set(300,300);
                            bomb.boxCollider.position.set((int) bomb.position.x - 20, (int) bomb.position.y - 20);
                            return true;
                        }
                    });
        }

        if (Level.level == 2) {
            this.addAction(new LimitAction(
                    new ActionAdapter() {
                        @Override
                        public boolean run(GameObject owner) {
                            Bomb bomb = GameObjectManager.instance.recycle(Bomb.class);
                            bomb.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                            bomb.boxCollider.position.set((int) bomb.position.x - 20, (int) bomb.position.y - 20);
                            return true;
                        }
                    },
                    2)
            );
        }
    }

        @Override
        public void run () {
            super.run();
        }
    }
