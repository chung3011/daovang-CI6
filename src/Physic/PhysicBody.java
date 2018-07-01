package Physic;

import Base.GameObject;

public interface PhysicBody {

    BoxCollider getBoxCollider();

    void getHit(GameObject gameObject);
}
