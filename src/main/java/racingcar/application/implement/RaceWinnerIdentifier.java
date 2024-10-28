package racingcar.application.implement;

import java.util.List;

public interface RaceWinnerIdentifier<T> {

    List<T> identify(List<T> racers);
}
