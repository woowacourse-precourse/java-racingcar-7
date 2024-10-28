package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameSequenceRepository;

public class GameService {
    private static final int FORWARD_CONDITION = 4;

    private final GameSequenceRepository gameSequenceRepository = new GameSequenceRepository();

    public void play(Game game) {
        for (Car car : game.getCars()) {
            if (FORWARD_CONDITION <= Randoms.pickNumberInRange(0, 9)) {
                car.moveForward();
            }
        }
        game.incrementProgress();
    }

    public void save(Game game) {
        gameSequenceRepository.save(game);
    }

    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
