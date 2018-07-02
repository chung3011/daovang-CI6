package scene;

import Base.GameObjectManager;
import Game.*;
import Game.Background.Background;
import Game.Bomb.BombGenerator;
import Game.Effect.ShieldEffect;
import Game.Effect.SpeedEffect;
import Game.ObjectsToCatch.LargeObject.LargeObjectGenerator;
import Game.ObjectsToCatch.LeavesGenerator;
import Game.ObjectsToCatch.MediumObject.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObject.SmallObjectGenerator;

public class GamePlayScene implements Scene {


    public void setUpCharacters() {

        GameObjectManager.instance.recycle(Anchor.class);
        GameObjectManager.instance.recycle(Player.class);

        GameObjectManager.instance.recycle(SmallObjectGenerator.class);
        GameObjectManager.instance.recycle(LargeObjectGenerator.class);
        GameObjectManager.instance.recycle(MediumObjectGenerator.class);
        GameObjectManager.instance.recycle(SpeedEffect.class);
        GameObjectManager.instance.recycle(ShieldEffect.class);
        GameObjectManager.instance.add(new BombGenerator());
        GameObjectManager.instance.add(new LeavesGenerator());
    }

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        this.setUpCharacters();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }
}
