package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printIntermediateResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            printIntermediateScore(car.getScore());
            System.out.println();
        }
    }

    public static void printMultipleResults(List<Car> cars, int tryNum) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
            printIntermediateResults(cars);
        }
    }

    public static void printIntermediateScore(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
    }

    public static void printFinalResults() {
        System.out.println("최종 우승자 : ");
        // TODO: 최종 우승자를 구현한 후 출력
    }
}
