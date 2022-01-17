package mockedunicorns.model;

import java.io.Serializable;
import java.util.Objects;

public class Unicorn implements Serializable {
    private String name;

    public Unicorn(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unicorn unicorn = (Unicorn) o;
        return Objects.equals(name, unicorn.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Unicorn{" +
                "name='" + name + '\'' +
                '}';
    }
}
