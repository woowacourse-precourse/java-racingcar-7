package racingcar.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Name;
import racingcar.model.game.attempt.Attempt;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Positions;

public class RacingCar {

    private final Cars cars;
    private final Positions positions;
    private final History history;
    private final Attempt attempt;

    public RacingCar(final Cars cars, final Attempt attempt) {
        this.cars = cars;
        this.positions = Positions.createWithNewRound(cars.size());
        this.history = new History(new ArrayList<>());
        this.attempt = attempt;
    }

    public void start() {
        for (int round = 0; round < attempt.attempt(); round++) {
            List<Boolean> moves = cars.doMove();
            moveWithPositions(moves);
        }
    }

    public String calculateWinners() {
        return positions.findWinnersIndices()
                .stream()
                .map(cars::at)
                .map(Car::name)
                .map(Name::name)
                .collect(Collectors.joining(", "));
    }

    private void moveWithPositions(final List<Boolean> moves) {
        for (int j = 0; j < cars.size(); j++) {
            if (moves.get(j)) {
                positions.increase(j);
            }
        }
        history.add(positions);
    }

    public Cars cars() {
        return cars;
    }

    public History history() {
        return history;
    }
}
