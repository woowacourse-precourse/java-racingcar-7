package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarNameHandler {

    private List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        if (carNames.isEmpty() || carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("두 대 이상의 자동차 이름을 입력해야 합니다.");
        }
        return carNames;
    }

    public RacingCars storeCar(String input) {
        List<String> carNames = splitCarNames(input);
        RacingCars racingCars = new RacingCars();
        racingCars.addCars(carNames);
        return racingCars;
    }

    public void printWinCarNames(RacingCars racingCars) {
        List<String> winners = racingCars.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
