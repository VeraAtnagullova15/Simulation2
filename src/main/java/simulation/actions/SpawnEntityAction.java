package simulation.actions;

import simulation.core.WorldMap;
import simulation.entities.Entity;


public class SpawnEntityAction extends SpawnAction {

    @Override
    public void execute(WorldMap worldMap) {
        for (var entry : ENTITY_MAX_NUMBER.entrySet()) {
            Class<? extends Entity> typeEntity = entry.getKey();
            int amount = entry.getValue();

            spawn(worldMap, typeEntity, amount);
        }
    }

}
