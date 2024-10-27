package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.util.parser.InputStringParser;

public class RaceGameServiceImpl implements RaceGameService{
    @Override
    public List<Car> enrollRacer(String racerNames, InputStringParser stringParser) {
        Set<String> parsedRacerNames = stringParser.extractTokens(racerNames);
        List<Car> racers = new ArrayList<>();
        for(String racerName : parsedRacerNames){
            Car racer = new Car(racerName);
            racers.add(racer);
        }
        return racers;
    }
}
