package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.repository.GameRepository;

public class GameService {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_VALUE = -1;
    private final GameRepository gameRepository =new GameRepository();

    public void play(Game game) {
        moveForwardByRandomNumber(game);
        game.increaseTrialNum();
    }

    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    public Boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }

    public Long save(Game game) {
        return gameRepository.save(game);
    }

    private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCurrentPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getMaxPosition(List<Car> cars) {
        int max = MIN_VALUE;
        for (Car car : cars) {
            if (max < car.getCurrentPosition()) {
                max = car.getCurrentPosition();
            }
        }
        return max;
    }

    private void moveForwardByRandomNumber(Game game) {
        for(Car car : game.getCars()) {
            if (FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward(1);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }


}