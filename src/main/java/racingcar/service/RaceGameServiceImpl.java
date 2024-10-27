package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.util.parser.StringParser;

public class RaceGameServiceImpl implements RaceGameService{
    @Override
    public List<Car> enrollRacer(String racerNames, StringParser stringParser) {
        Set<String> parsedRacerNames = stringParser.extractTokens(racerNames);
        List<Car> racers = new ArrayList<>();
        for(String racerName : parsedRacerNames){
            Car racer = new Car(racerName);
            racers.add(racer);
        }
        return racers;
    }

    @Override
    public void progressRound(List<Car> cars, Referee referee) {
        for (Car car : cars){
            if(referee.judgeRacerCanMove()) {
                car.moveFoward();
            }
        }
    }

    @Override
    public List<Car> findWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
        for (Car car : cars){
            if(car.getMoveCount() == maxMoveCount){
                winner.add(car);
            }
        }
        return winner;
    }


}
