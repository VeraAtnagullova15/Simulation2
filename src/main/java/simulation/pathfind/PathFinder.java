package simulation.pathfind;

import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;

import java.util.List;

public interface PathFinder {
    public final static List<Coordinates> SHIFTS = List.of(
            new Coordinates(-1, 0),
            new Coordinates(0, 1),
            new Coordinates(1, 0),
            new Coordinates(0, -1));
    public List<Coordinates> findPath(WorldMap worldMap, Coordinates from, Class<? extends Entity> target);
}
