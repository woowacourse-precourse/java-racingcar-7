package racingcar.infrastructure;

import java.util.List;
import racingcar.domain.Vehicle;

public interface RacingHistory {
    void addRound(long round, List<Vehicle> cars);
    List<Vehicle> getCars(Long round);
    int getSize();
}
