import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;

    private GameObjectManager() {
        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.list.add(gameObject);
    }

    public void runAll() {
        this.list.forEach(gameObject -> gameObject.run());
    }

    public void renderAll(Graphics graphics) {
        this.list.forEach(gameObject -> gameObject.render(graphics));
//        graphics.setColor(Color.WHITE);
//        Player player = this.findPlayer();
//        Anchor anchor = this.findAnchor();

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
}