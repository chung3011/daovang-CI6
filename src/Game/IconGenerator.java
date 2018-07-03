package Game;

import Base.GameObjectManager;
import Constant.Constant;
import Game.Effect.ShieldEffect;
import Game.Effect.ShieldEffectIcon;
import Game.Effect.SpeedEffectIcon;
import Game.ObjectsToCatch.LargeObject.LargeObjectIcon;
import Game.ObjectsToCatch.Leaves.LeavesIcon;
import Game.ObjectsToCatch.MediumObject.MediumObjectIcon;
import Game.ObjectsToCatch.SmallObject.SmallObjectIcon;

public class IconGenerator {
    public int horizonPosObject = Constant.Icon.HORIZONTALPOSITION;
    public int verticalPosObject;
    public int effectHorizontalPos = Constant.Icon.HORIZONTALPOSITION;
    public int effectVerticalPos;

    public static IconGenerator instance = new IconGenerator();

    private IconGenerator() {
        this.verticalPosObject = 20;
        this.effectVerticalPos = 45;
    }

    public LargeObjectIcon addLargeObjectIcon() {
        LargeObjectIcon largeObjectIcon = new LargeObjectIcon();
        largeObjectIcon.position.set(verticalPosObject, horizonPosObject);
        this.changeHorizontalPos();
        return largeObjectIcon;
    }


    public MediumObjectIcon addMediumObjectIcon() {
        MediumObjectIcon mediumObjectIcon = new MediumObjectIcon();
        mediumObjectIcon.position.set(verticalPosObject, horizonPosObject);
        this.changeHorizontalPos();
        return mediumObjectIcon;
    }


    public SmallObjectIcon addSmallObjectIcon() {
        SmallObjectIcon smallObjectIcon = new SmallObjectIcon();
        smallObjectIcon.position.set(verticalPosObject, horizonPosObject);
        this.changeHorizontalPos();
        return smallObjectIcon;
    }


    public LeavesIcon addLeaf() {
        LeavesIcon leafIcon = new LeavesIcon();
        leafIcon.position.set(verticalPosObject, horizonPosObject);
        this.changeHorizontalPos();
        return  leafIcon;
    }

    public ShieldEffectIcon addShieldIcon() {
        ShieldEffectIcon shieldEffectIcon = new ShieldEffectIcon();
        shieldEffectIcon.position.set(effectHorizontalPos, effectVerticalPos);
        this.effectHorizontalPos += 25;
        return  shieldEffectIcon;
    }

    public SpeedEffectIcon addSpeedIcon() {
        SpeedEffectIcon speedEffectIcon = new SpeedEffectIcon();
        speedEffectIcon.position.set(effectHorizontalPos, effectVerticalPos);
        this.effectHorizontalPos += 25;
        return  speedEffectIcon;
    }

    public void resetVerticalPos() {
        this.verticalPosObject = 20;
        this.effectVerticalPos = 45;
    }

    private void changeHorizontalPos() {
        this.verticalPosObject += 25;
    }
}
