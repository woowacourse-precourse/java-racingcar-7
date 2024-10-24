package repository;

import java.util.List;
import java.util.Set;
import vehicle.Vehicle;

public interface Repository {
    Boolean isDuplicateName(String name);

    void save(String name, Vehicle vehicle);

    Vehicle find(String name);

    int size();

    Set<String> repositoryKeyset();

    List<String> findWinner();


}
