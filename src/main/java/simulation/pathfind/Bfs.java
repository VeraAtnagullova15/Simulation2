package simulation.pathfind;

import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;

import java.util.*;

public class Bfs implements PathFinder {

    @Override
    public List<Coordinates> findPath(WorldMap worldMap, Coordinates from, Class<? extends Entity> target) {
        Queue<Coordinates> neighbors = new ArrayDeque<>();
        Map<Coordinates, Coordinates> path = new HashMap<>();
        Set<Coordinates> visited = new HashSet<>();
        List<Coordinates> rightPath = new ArrayList<>();

        neighbors.add(from);
        visited.add(from);

        while (!neighbors.isEmpty()) {
            Coordinates current = neighbors.poll();
            for (Coordinates shift : SHIFTS) {
                Coordinates nextStep = addShift(current, shift);
                if (!worldMap.isCellInside(nextStep)) {
                    continue;
                }
                if (visited.contains(nextStep)) {
                    continue;
                }
                Optional<Entity> nextEntityOptional = Optional.ofNullable(worldMap.getEntity(nextStep));
                if (nextEntityOptional.isEmpty()) {
                    path.put(nextStep, current);
                    neighbors.add(nextStep);
                    visited.add(nextStep);
                } else {
                    Entity nextEntity = nextEntityOptional.get();
                    if (!target.isInstance(nextEntity)) {
                        visited.add(nextStep);
                    } else {
                        path.put(nextStep, current);
                        rightPath = reversPath(path, from, nextStep);
                        return rightPath;
                    }
                }

            }
        }
        return rightPath;
    }


    private Coordinates addShift(Coordinates one, Coordinates two) {
        return new Coordinates(one.row() + two.row(), one.column() + two.column());
    }

    private List<Coordinates> reversPath(Map<Coordinates, Coordinates> path, Coordinates from, Coordinates to) {
        List<Coordinates> rightPath = new ArrayList<>();
        Coordinates current = to;
        while ((current != null) && (!current.equals(from))) {
            rightPath.add(current);
            current = path.get(current);
        }
        Collections.reverse(rightPath);
        return rightPath;
    }

}



