package scene;

import Base.GameObjectManager;
import Game.Anchor;
import Game.Background;
import Game.BombGenerator;
import Game.ObjectsToCatch.LargeObjectGenerator;
import Game.ObjectsToCatch.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObjectGenerator;
import Game.Player;

public class GamePlayScene implements Scene {
    @Override
    public void init() {
        this.setUpCharacters();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    public void setUpCharacters() {
        GameObjectManager.instance.add(new Anchor());
        GameObjectManager.instance.add(new Player());
        GameObjectManager.instance.add(new Background());

        GameObjectManager.instance.add(new SmallObjectGenerator());
        GameObjectManager.instance.add(new LargeObjectGenerator());
        GameObjectManager.instance.add(new MediumObjectGenerator());
        GameObjectManager.instance.add(new BombGenerator());
        GameObjectManager.instance.add(new Player());
    }

//    public void startCatching() {
//        Anchor anchor = GameObjectManager.instance.findAnchor();
//        Player player = GameObjectManager.instance.findPlayer();
//        anchor.isCatching = true;
//        anchor.isDropping = true;
//        anchor.ropeDirection.set(anchor.position);
//        anchor.movingDirection.set(anchor.position.subtract(player.getPosition()).normalize().multiply(3));
//    }
}
