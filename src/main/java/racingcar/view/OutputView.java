package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printSetCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printSetCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printStartRacing() {
        System.out.println("실행 결과");
    }

    public static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinner(String winnerCar) {
        System.out.println("최종 우승자 : " + winnerCar);
    }
}
