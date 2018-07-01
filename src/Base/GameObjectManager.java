package Base;

import Game.Anchor;
import Game.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;


    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));

        Anchor anchor = this.findAnchor();
        if (anchor != null) {
            Player player = this.findPlayer();
            graphics.setColor(Color.WHITE);

            if (!anchor.isCatching) {
                graphics.drawLine( (int) player.getPosition().x, (int) player.getPosition().y,
                        (int) anchor.position.x, (int) anchor.position.y);
            }
            else if (anchor.isCatching) {
                graphics.drawLine((int) player.getPosition().x, (int) player.getPosition().y,
                        (int) anchor.ropeDirection.x, (int) anchor.ropeDirection.y);
            }
        }
    }

    public <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject instanceof PhysicBody)
                .filter(gameObject -> {
                    BoxCollider other = ((PhysicBody)gameObject).getBoxCollider();
                    return boxCollider.checkBoxCollider(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T object = (T) this.list
                .stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);
        if (object != null) {
            object.isAlive = true;
        } else {
            try {
                object = cls.newInstance();
                this.add(object);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

    public Anchor findAnchor() {
        return (Anchor) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Anchor)
                .findFirst()
                .orElse(null);
    }

    public void clear(){
        this.list.clear();
        this.tempList.clear();
    }
}