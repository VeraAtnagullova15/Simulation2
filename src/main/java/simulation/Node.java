package simulation;

import java.util.Objects;

public class Node {

    private Coordinates previous;
    private Coordinates current;

    public Node(Coordinates previous, Coordinates current) {
        this.previous = previous;
        this.current = current;
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
