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
            checkRuleStopOrMove(racingGame, car, randomNumber);
        }
    }

    public void checkRuleStopOrMove(RacingGame racingGame, Car car, int randomNumber) {
        if (racingGame.getGameRule().moveForward(randomNumber)) {
            car.moveForward();
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
            displayRaceStatus(racingGame);
        }
    }

    private void displayRaceStatus(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            OutputView.printRacingCar(car.getName(), car.getPosition());
        }
    }

    private int getMaxPosition(RacingGame racingGame) {
        return racingGame.getCars().stream()
                .map(Car::getPosition)
                .sorted(Comparator.reverseOrder())
                .toList().getFirst();
    }

    private List<Car> getWinnerCar(RacingGame racingGame) {
        List<Car> winnerCar = new ArrayList<>();
        int maxPosition = getMaxPosition(racingGame);
        for (Car car : racingGame.getCars()) {
            findWinnerCar(car, maxPosition, winnerCar);
        }

        return winnerCar;

    }

    private void findWinnerCar(Car car, int maxPosition, List<Car> winnerCar) {
        if (car.getPosition() == maxPosition) {
            winnerCar.add(car);
        }
    }

    public List<String> getWinnerCarName(RacingGame racingGame) {
        return getWinnerCar(racingGame).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
