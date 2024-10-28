package racingcar.view;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printRaceResult(List<Map<Car, Integer>> raceResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("실행 결과\n");

        String output = raceResults.stream()
                .map(map -> toStringResult(map))
                .collect(Collectors.joining("\n\n"));
        stringBuilder.append(output);

        System.out.println(stringBuilder.toString() + "\n");
    }

    private String toStringResult(Map<Car, Integer> map) {
        return map.entrySet().stream()
                .map(entry -> {
                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(entry.getKey().getCarName());
                    stringBuilder.append(" : ");
                    stringBuilder.append("-".repeat(entry.getValue()));
                    return stringBuilder.toString();

                }).collect(Collectors.joining("\n"));
    }

    public void printNames(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        String output = stringBuilder.append("최종 우승자 : ")
                .append(toStringNames(winners))
                .toString();

        System.out.println(output);
    }

    private String toStringNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }
}
