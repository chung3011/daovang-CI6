package Action;


import Base.GameObject;

public interface Action {

    boolean run(GameObject owner);

    void reset();
}
