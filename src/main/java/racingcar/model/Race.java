package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.RaceResultStringGenerator;

import java.util.List;

public class Race {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

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

    public String startRace(){
        StringBuilder resultString = new StringBuilder();
        while (tryCount.isNotZero()) {
            moveCars();
            resultString.append(raceResultStringGenerator.generateRaceResultString(cars));
            tryCount.reduceTryCount();
        }
        return resultString.toString();
    }

    public void moveCars() {
        for(Car car : this.cars){
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            car.move(randomNumber);
        }
    }

    public List<String> findWinner(){
        return this.winner.findWinner(this.cars);
    }
}