package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.parser.StringParser;

public interface RaceGameService {
    List<Car> enrollRacer(String racerNames, StringParser stringParser);
}
