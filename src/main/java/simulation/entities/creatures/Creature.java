package simulation.entities.creatures;

import simulation.Bfs;
import simulation.Coordinates;
import simulation.Node;
import simulation.WorldMap;
import simulation.entities.Entity;

import java.util.List;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected final static int MAX_HP = 100;
    protected Class<? extends Entity> target;
    Bfs bfs = new Bfs();


    public Creature(int speed, int hp, Class<? extends Entity> target) {
        this.speed = speed;
        this.hp = hp;
        this.target = target;
    }

    public void makeMove(WorldMap worldMap) {
        Coordinates current = worldMap.getCoordinates(this);
        List<Coordinates> path = bfs.findPath(worldMap, current, target);
        if (path.isEmpty()) {
            return;
        }
        if (path.size() == 1) {
            //to do eat or attack;
        }
        worldMap.moveEntity(this, path.get(0));
    }
}
