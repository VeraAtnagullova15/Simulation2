package simulation.factory;

import simulation.entities.Entity;

public interface EntityFactory {
    Entity create (Class<? extends Entity> entityType);
}
