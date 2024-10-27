package racingcar.model.Util;

import racingcar.model.Car.Car;

import java.util.List;
import java.util.stream.Collectors;

public final class StringGenerator implements DelimiterSymbols {
    String MOVE_CHAR = "-";
    String COLON = " : ";

    public StringBuilder generateWinnerResult(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자"+COLON);
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(STANDARD_DELIMITER+" "));

        sb.append(winnerNames);
        return sb;
    }

    public StringBuilder generateRaceResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");

        for (Car car : cars) {
            String raceResult = car.getRaceResult(COLON, MOVE_CHAR);
            sb.append(raceResult).append("\n");
        }

        return sb;
    }
}
