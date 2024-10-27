package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printRacing(List<Car> racingCars) {
        StringBuilder currentPosition = new StringBuilder();
        for (Car car : racingCars) {
            currentPosition.append(car.getName()).append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        System.out.println(currentPosition.toString());
    }

    public static void printWinner(List<String> winners){
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ")
                .append(String.join(", ", winners));
        System.out.println(result);
    }
}
