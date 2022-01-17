package mockedunicorns;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import mockedunicorns.model.Unicorn;
import mockedunicorns.model.UnicornAlreadyPairedException;
import mockedunicorns.model.UnicornException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnicornsManager {

    private final Set<Unicorn> unicorns = new HashSet<>();
    private final Set<Pair<Unicorn, Unicorn>> unicornPairs = new HashSet<>();

    public void add(Unicorn unicorn) {
        unicorns.add(unicorn);
    }

    public Collection<Unicorn> getUnicorns() {
        return Collections.unmodifiableSet(unicorns);
    }

    public void pair(Unicorn unicorn1, Unicorn unicorn2) throws UnicornAlreadyPairedException {
        if (unicorns.contains(unicorn1) && unicorns.contains(unicorn2)) {
            if (getPaired(unicorn1) != null || getPaired(unicorn2) != null) {
                throw new UnicornAlreadyPairedException("At least one of the unicorns already paired.");
            }
            unicornPairs.add(new ImmutablePair<>(unicorn1, unicorn2));
        }
    }

    public Unicorn getPaired(Unicorn unicorn) {
        for (Pair<Unicorn, Unicorn> pair : unicornPairs) {
            if (pair.getLeft().equals(unicorn)) {
                return pair.getRight();
            }
            if (pair.getRight().equals(unicorn)) {
                return pair.getLeft();
            }
        }
        return null;
    }

    public void load(File file) throws UnicornException {
        if (!file.exists()) {
            throw new UnicornException(new FileNotFoundException());
        }
        if (file.isDirectory() || !file.canRead()) {
            throw new UnicornException(new IOException());
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);) {
            String line;
            while ((line = br.readLine()) != null) {
                Unicorn unicorn = new Unicorn(line);
                unicorns.add(unicorn);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
