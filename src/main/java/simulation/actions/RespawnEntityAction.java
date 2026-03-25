package simulation.actions;

import simulation.core.WorldMap;
import simulation.entities.Entity;

import java.util.List;

public class RespawnEntityAction extends SpawnAction{
    private final static int ENTITY_EMOUNT_FOR_REFRESH = 2;
    @Override
    public void execute(WorldMap worldMap) {
        for (var entry : ENTITY_MAX_NUMBER.entrySet()) {
            Class<? extends Entity> typeEntity = entry.getKey();
            int amount = entry.getValue();
            List<? extends Entity> entities = worldMap.getAllCreatures(typeEntity);
            if (entities.size() < amount / 2) {
                spawn(worldMap, typeEntity, ENTITY_EMOUNT_FOR_REFRESH);
            }
        }
    }
}
