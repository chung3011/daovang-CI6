package scene;

import Base.GameObjectManager;
import Game.*;
import Game.Background.Background;
import Game.Bomb.BombGenerator;
import Game.Cockcroach.CockcroachGenerator;
import Game.Effect.ShieldEffect;
import Game.Effect.SpeedEffect;
import Game.ObjectsToCatch.LargeObject.LargeObjectGenerator;
import Game.ObjectsToCatch.Leaves.LeavesGenerator;
import Game.ObjectsToCatch.MediumObject.MediumObjectGenerator;
import Game.ObjectsToCatch.SmallObject.SmallObjectGenerator;
import Utils.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {
    Clip themeSound = Utils.loadAudio("resources/audio/spring-weather-2.wav");

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
        GameObjectManager.instance.add(new CockcroachGenerator());
        System.out.println(Level.level);
    }

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        this.setUpCharacters();

        themeSound.loop(-1);
        themeSound.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        themeSound.stop();
    }
}
