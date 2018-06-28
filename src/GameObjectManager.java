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
        graphics.setColor(Color.WHITE);
        Player player = this.findPlayer();
        Anchor anchor = this.findAnchor();
        graphics.fillOval((int) player.getPosition().x - 3, (int)player.getPosition().y - 4, 7, 7);

        if (!anchor.isCatching) {
            graphics.drawLine( (int) player.getPosition().x, (int) player.getPosition().y, (int) anchor.position.x, (int) anchor.position.y);
        }

        else if (anchor.isCatching) {
            graphics.drawLine((int) player.getPosition().x, (int) player.getPosition().y,
                    (int) anchor.ropeDirection.x, (int) anchor.ropeDirection.y);
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