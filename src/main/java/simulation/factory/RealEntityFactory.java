package simulation.factory;

import simulation.entities.Entity;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.map_objects.Grass;
import simulation.entities.map_objects.Rock;
import simulation.entities.map_objects.Tree;

import java.util.Map;
import java.util.function.Supplier;

public class RealEntityFactory implements EntityFactory {

    private final Map<Class<? extends Entity>, Supplier<? extends Entity>> creators = Map.of(
            Herbivore.class, () -> new Herbivore(),
            Predator.class, () -> new Predator(),
            Grass.class, () -> new Grass(),
            Rock.class, () -> new Rock(),
            Tree.class, () -> new Tree()
    );

    @Override
    public Entity create(Class<? extends Entity> entityType) {
        Supplier<? extends Entity> creator = creators.get(entityType);
        return creator.get();
    }
}
