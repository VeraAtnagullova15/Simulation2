package simulation.entities.creatures;

import simulation.core.Coordinates;
import simulation.core.WorldMap;

public class Predator extends Creature {
    protected int attackPower;
    private static final int PREDATOR_SPEED = 2;
    private static final int POWER_ATTACK = 50;

    public Predator() {
        super(PREDATOR_SPEED, MAX_HP, Herbivore.class);
        this.attackPower = POWER_ATTACK;
    }

    @Override
    void interact(WorldMap worldMap, Coordinates victim) {
        Creature victimEntity = (Creature)worldMap.getEntity(victim);
        int currentVictimHP = victimEntity.getHp();
        System.out.println("CurrentVictimHP:" + currentVictimHP);
        victimEntity.setHp(currentVictimHP - this.attackPower);
        System.out.println("VictimHP after attack: " + victimEntity.hp);
        if(victimEntity.isDead()) {
            worldMap.removeEntity(victimEntity);
        }
    }

}
