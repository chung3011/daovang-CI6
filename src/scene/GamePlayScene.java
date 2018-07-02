package scene;

import Base.GameObjectManager;
import Game.*;
import Game.ObjectsToCatch.LargeObjectGenerator;
import Game.ObjectsToCatch.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObjectGenerator;

public class GamePlayScene implements Scene {


    public void setUpCharacters() {

        GameObjectManager.instance.add(new Anchor());
        GameObjectManager.instance.add(new Player());
        GameObjectManager.instance.add(new Background());

        GameObjectManager.instance.add(new SmallObjectGenerator());
        GameObjectManager.instance.add(new LargeObjectGenerator());
        GameObjectManager.instance.add(new MediumObjectGenerator());
//        GameObjectManager.instance.add(new BombGenerator());
        GameObjectManager.instance.add(new Player());
    }
    @Override
    public void init() {
        this.setUpCharacters();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();

    }
}
