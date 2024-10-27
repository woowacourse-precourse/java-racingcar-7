package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.parser.InputStringParser;

public interface RaceGameService {
    List<Car> enrollRacer(String racerNames, InputStringParser stringParser);
}
