package simulation.entities.creatures;

import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;
import simulation.entities.map_objects.Grass;

public class Herbivore extends Creature {
    private final static int HERBIVORE_SPEED = 1;

    public Herbivore() {
        super(HERBIVORE_SPEED, MAX_HP, Grass.class);
    }

    @Override
    void interact(WorldMap worldMap, Coordinates target) {
        Entity targetEntity = worldMap.getEntity(target);
        worldMap.removeEntity(targetEntity);
    }
}
