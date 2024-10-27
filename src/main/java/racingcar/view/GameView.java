package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    public void displayInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayInputRoundNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void displayRoundStart() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void displayRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(renderPosition(car));
        }
        System.out.println();
    }

    public String renderPosition(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public void displayWinners(List<Car> winnerCars) {
        String result = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
