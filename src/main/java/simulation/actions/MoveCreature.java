package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.creatures.Creature;

import java.util.List;

public class MoveCreature extends Action {

    @Override
    public void execute(WorldMap worldMap) {
        List<Creature> allCreatures = worldMap.getAllCreatures(Creature.class);
        for (Creature creature : allCreatures) {
            creature.makeMove(worldMap);
        }
    }
}
