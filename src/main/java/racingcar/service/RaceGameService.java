package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.util.parser.StringParser;

public interface RaceGameService {
    List<Car> enrollRacer(String racerNames, StringParser stringParser);

    void progressRound(List<Car> cars, Referee referee);
}
