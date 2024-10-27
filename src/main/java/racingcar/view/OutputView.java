package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class OutputView {
    public static void carNameOutView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNumberOutView() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void excuteResult() {
        System.out.println("실행 결과");
    }

    public static void resultPerTry(List<Car> racingCar) {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCar) {
            sb.append(car.getCarName());
            sb.append(" : ");
            sb.append("-".repeat(car.getPosition()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void outputWinner(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (Car winner : winners) {
            sb.append(winner.getCarName());
            sb.append(", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
