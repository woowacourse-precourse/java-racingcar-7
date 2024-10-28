package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class Results {

    private final List<Result> results;

    private Results() {
        this.results = new ArrayList<>();
    }

    private Results(final List<Result> results) {
        this.results = results;
    }

    public Results copy() {
        return new Results(this.results);
    }

    public static Results empty() {
        return new Results();
    }

    public void saveAll(final List<Car> cars) {
        Result result = Result.empty();
        for (Car car : cars) {
            result.save(car.name(), car.position());
        }
        results.add(result);
    }

    public Position findWinnerPosition() {
        Collection<Position> finalPositions = getFinalPositions();
        return finalPositions.stream()
                .max(Position::compareTo)
                .orElse(Position.zero());
    }

    private Collection<Position> getFinalPositions() {
        return results.getLast()
                .getResult()
                .values();
    }

    public List<Result> getResults() {
        return results.stream()
                .toList();
    }

}
