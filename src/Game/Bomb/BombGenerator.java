package Game.Bomb;

import Action.*;
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
            this.addAction(new LimitAction( new SequenceAction(
                    new ActionAdapter() {
                        @Override
                        public boolean run(GameObject owner) {
                            Bomb bomb = GameObjectManager.instance.recycle(Bomb.class);
//                            bomb.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                            bomb.position.set(0, 150 + random.nextInt(Constant.Window.HEIGHT - 150));
                            bomb.velocity.set(1+random.nextInt(5), 0);
                            return true;
                        }
                    },
                    new WaitAction(50)
            ),
            2));
        }


        if (Level.level == 2) {
            this.addAction(new RepeatActionForever(new SequenceAction(
                    new ActionAdapter() {
                        @Override
                        public boolean run(GameObject owner) {
                            Bomb bomb = GameObjectManager.instance.recycle(Bomb.class);
//                            bomb.position.set(60 + random.nextInt(900),160 +  random.nextInt(380));
                            bomb.position.set(0, 150 + random.nextInt(Constant.Window.HEIGHT -150));
                            bomb.velocity.set(1+random.nextInt(5), 0);
                            return true;
                        }
                    },
                    new WaitAction(1000))
            ));
        }
    }

        @Override
        public void run () {
            super.run();
        }
    }
