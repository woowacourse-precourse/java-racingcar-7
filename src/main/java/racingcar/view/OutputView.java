package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void trialCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showRaceStatus(List<Car> racingCars) {
        for (Car car : racingCars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void finalWinnerMessage(List<Car> winnerCars) {
        String winnerCarsName = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerCarsName);
    }
}
