package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarNameHandler {

    private List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());
    }

    public RacingCars storeCar(String input) {
        List<String> carNames = splitCarNames(input);
        RacingCars racingCars = new RacingCars();
        racingCars.addCars(carNames); // 자동차 이름을 통해 Car 객체 생성 및 추가
        return racingCars;
    }

    public void printWinCarNames(RacingCars racingCars) {
        List<String> winners = racingCars.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}