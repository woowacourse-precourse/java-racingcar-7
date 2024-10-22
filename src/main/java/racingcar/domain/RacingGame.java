package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<Car> cars, int attempts){
        this.cars = cars;
        this.attempts = attempts;
    }

    public void play() {
        for(int i = 0; i < attempts; i++){
            playRound();
            System.out.println();
        }
    }

    private void playRound() {
        for(Car car : cars){
            int number = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(number >= MOVE_THRESHOLD);
            System.out.println(car.toString());
        }
    }

    public List<String> getWinners() {
       int maxPosition = getMaxPosition();
       return cars.stream()
               .filter(car -> car.getPosition() == maxPosition)
               .map(Car::getName)
               .collect(Collectors.toCollection(ArrayList::new));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}