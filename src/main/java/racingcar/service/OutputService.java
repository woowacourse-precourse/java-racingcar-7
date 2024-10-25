package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.domain.Car;
import racingcar.domain.Record;
import racingcar.domain.Result;

public class OutputService {

    public String generateResultMessage(List<Result> results) {
        StringBuilder sb = new StringBuilder();

        for (Result result : results) {
            addResult(sb, result);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private void addResult(StringBuilder sb, Result result) {
        for (Record record : result.getRecords()) {
            sb.append(record.getCarName()).append(" : ");
            sb.append(convertToDash(record.getDistance()));
            sb.append(System.lineSeparator());
        }
    }

    private String convertToDash(int distance) {
        return "-".repeat(distance);
    }

    public String generateWinnerMessage(List<Car> cars) {
        List<String> winners = getWinners(cars);
        return String.join(Constant.DELIMITER, winners);
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        sortCars(cars);
        int maxDistance = cars.getFirst().getDistance();
        for (Car car : cars) {
            addWinners(winners, car, maxDistance);
        }

        return winners;
    }

    private void sortCars(List<Car> cars) {
        cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
    }

    private void addWinners(List<String> winners, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }
}
