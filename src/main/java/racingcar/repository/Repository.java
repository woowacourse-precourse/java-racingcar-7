package racingcar.repository;

import java.util.List;
import racingcar.domain.Vehicle;

public interface Repository {

    void save(String name, Vehicle vehicle);

    Vehicle find(String name);

    int size();

    List<String> findWinner();


}
