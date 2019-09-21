package Controllable;

import Utils.Direction;

public interface ControllableCharacter {

    void setDirection(Direction dir);
    void updatePosition();
}
