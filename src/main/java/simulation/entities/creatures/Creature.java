package simulation.entities.creatures;

import simulation.pathfind.Bfs;
import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;
import simulation.pathfind.BfsWithNode;
import simulation.pathfind.PathFinder;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected final static int MAX_HP = 100;
    protected Class<? extends Entity> target;
    PathFinder bfs;


    public Creature(int speed, int hp, Class<? extends Entity> target) {
        this.speed = speed;
        this.hp = hp;
        this.target = target;
        bfs = new BfsWithNode();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    abstract void interact(WorldMap worldMap, Coordinates target);

    public void makeMove(WorldMap worldMap) {
        for (int i = 0; i < speed; i++) {
            try {
                Coordinates current = worldMap.getCoordinates(this);
                List<Coordinates> path = bfs.findPath(worldMap, current, target);
                System.out.println(path);

                if (path.isEmpty()) {
                    return;
                }
                if (path.size() == 1) {
                    Coordinates targetStep = path.get(0);
                    interact(worldMap, targetStep);
                }
                worldMap.moveEntity(this, path.get(0));
            } catch (NoSuchElementException e) {
                return;
            }
        }
    }

    protected boolean isDead() {
        return hp <= 0;
    }


}
