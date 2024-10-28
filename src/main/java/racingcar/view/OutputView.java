package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    // 라운드 결과 출력 메서드
    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    // 자동차 위치 '-'로 표시하는 메서드
    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();  // 위치 출력 후 줄바꿈
    }

    // 우승자 출력 메서드
    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
