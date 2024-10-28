package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Racingcar> cars;
    private final RandomGenerator randomGenerator;
    private final DetermineMove determineMove;
    private static final int NUMMIN = 0;
    private static final int NUMMAX = 9;

    public RacingGame(List<String> carNames){
        cars = carNames.stream().map(Racingcar::new).collect(Collectors.toList());
        randomGenerator = new RandomGenerator();
        determineMove = new DetermineMove();
    }

    public List<Racingcar> getCars(){
        return cars;
    }

    public void raceOneRound(){
        for(Racingcar car : cars){
            int randomNumber = randomGenerator.generateNumber(NUMMIN, NUMMAX);
            if(determineMove.shouldMove(randomNumber)){
                car.move();
            }
        }
    }

    public List<Racingcar> finalWinner() {
        int maxPosition = cars.stream().mapToInt(Racingcar::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }
}
