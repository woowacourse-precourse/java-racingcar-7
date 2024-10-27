package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.GameRule;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

public class GameService {

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void carRacing(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            int randomNumber = getRandomNumber();
            if (racingGame.getGameRule().moveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }

    public Car createCar(String name) {
        return new Car(name);
    }

    public GameRule determineGameCount(int gameCount) {
        return new GameRule(gameCount);
    }

    public RacingGame readyRacingGame(List<Car> cars, GameRule gameRule) {
        return new RacingGame(cars, gameRule);
    }

    public void play(RacingGame racingGame) {
        while (!racingGame.isTimeToEnd()) {
            racingGame.increaseGameCount();
            carRacing(racingGame);
            OutputView.printCarPositions(racingGame);
        }
    }

    public int getMaxPosition(RacingGame racingGame) {
        return racingGame.getCars().stream()
                .map(Car::getPosition)
                .sorted(Comparator.reverseOrder())
                .toList().get(0).intValue();
    }

    public List<Car> getWinnerCar(RacingGame racingGame) {
        List<Car> winnerCar = new ArrayList<>();
        int maxPosition = getMaxPosition(racingGame);
        for (Car car : racingGame.getCars()) {
            if (car.getPosition() == maxPosition) {
                winnerCar.add(car);
            }
        }

        return winnerCar;

    }

    public List<String> getWinnerCarName(RacingGame racingGame) {
        return getWinnerCar(racingGame).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
