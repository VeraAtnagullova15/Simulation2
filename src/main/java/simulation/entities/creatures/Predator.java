package simulation.entities.creatures;

public class Predator extends Creature {
    protected int attackPower;
    private static final int PREDATOR_SPEED = 2;
    private static final int POWER_ATTACK = 25;

    public Predator() {
        super(PREDATOR_SPEED, MAX_HP, Herbivore.class);
        this.attackPower = POWER_ATTACK;
    }

}
