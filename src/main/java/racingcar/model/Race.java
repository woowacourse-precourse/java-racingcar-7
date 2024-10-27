package racingcar.model;

import racingcar.util.MoveNumberGenerator;
import racingcar.util.RaceResultStringGenerator;
import racingcar.util.RandomMoveNumberGenerator;

import java.util.List;

public class Race {
    private List<Car> cars;
    private TryCount tryCount;
    private Winner winner;

    private RaceResultStringGenerator raceResultStringGenerator;

    public Race(List<Car> cars, TryCount tryCount, Winner winner, RaceResultStringGenerator raceResultStringGenerator){
        this.cars = cars;
        this.tryCount = tryCount;
        this.winner = winner;
        this.raceResultStringGenerator = raceResultStringGenerator;
    }

    public String startRace(MoveNumberGenerator moveNumberGenerator){
        StringBuilder resultString = new StringBuilder();
        while (tryCount.isNotZero()) {
            moveCars(moveNumberGenerator);
            resultString.append(raceResultStringGenerator.generateRaceResultString(cars));
            tryCount.reduceTryCount();
        }
        return resultString.toString();
    }

    private void moveCars(MoveNumberGenerator moveNumberGenerator) {
        for(Car car : this.cars){
            int randomNumber = moveNumberGenerator.makeMoveNumber();
            car.move(randomNumber);
        }
    }

    public List<String> findWinner(){
        return this.winner.findWinner(this.cars);
    }
}