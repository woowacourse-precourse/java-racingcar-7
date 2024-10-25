package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    public static void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printMoveCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarPosition(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printBarFromCarPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printBarFromCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
