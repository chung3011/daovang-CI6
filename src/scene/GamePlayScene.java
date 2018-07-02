package scene;

import Base.GameObject;
import Base.GameObjectManager;
import Game.*;
import Game.ObjectsToCatch.LargeObjectGenerator;
import Game.ObjectsToCatch.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObjectGenerator;

public class GamePlayScene implements Scene {


    public void setUpCharacters() {

        GameObjectManager.instance.recycle(Anchor.class);
        GameObjectManager.instance.recycle(Player.class);

        GameObjectManager.instance.recycle(SmallObjectGenerator.class);
        GameObjectManager.instance.recycle(LargeObjectGenerator.class);
        GameObjectManager.instance.recycle(MediumObjectGenerator.class);
//        GameObjectManager.instance.add(new BombGenerator());
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
