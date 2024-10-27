package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    /**
     * 실행 결과 출력 전, 설명 문구 출력
     */
    public static void printDescription() {
        System.out.println();
        System.out.println("실행 결과");
    }

    /**
     * 게임 1회 실행 결과 출력
     */
    public static void printGameResult(List<Car> cars) {
        for (Car car : cars) {
            String result = car.getCarName() + " : ";
            for (int i = 0; i < car.getMoveCount(); i++) {
                result += "-";
            }
            System.out.println(result);
        }
    }
}
