package simulation.entities.creatures;

import simulation.Coordinates;
import simulation.WorldMap;
import simulation.entities.Entity;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected final static int MAX_HP = 100;

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }

    public void makeMove(WorldMap worldMap) {
        Coordinates current = worldMap.getCoordinates(this);
        Coordinates to = new Coordinates(current.row(), current.column() + 1);
        worldMap.moveEntity(this, to);

    }
}
