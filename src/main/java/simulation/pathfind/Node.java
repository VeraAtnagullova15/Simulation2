package simulation.pathfind;

import simulation.core.Coordinates;

import java.util.Objects;

public class Node {

    private Coordinates current;
    private Coordinates previous;

    public Node(Coordinates current, Coordinates previous) {
        this.current = current;
        this.previous = previous;
    }

    public Coordinates getPrevious() {
        return previous;
    }

    public Coordinates getCurrent() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node node)) return false;
        return Objects.equals(getPrevious(), node.getPrevious()) && Objects.equals(getCurrent(), node.getCurrent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrevious(), getCurrent());
    }
}
