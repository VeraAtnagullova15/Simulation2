package simulation.entities.creatures;

import simulation.entities.map_objects.Grass;

public class Herbivore extends Creature {
    private final static int HERBIVORE_SPEED = 1;

    public Herbivore() {
        super(HERBIVORE_SPEED, MAX_HP, Grass.class);
    }

}
