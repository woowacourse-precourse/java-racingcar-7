package racingcar.view;

import racingcar.model.Car;

import java.util.List;
/**
 * 해당 클래스는 출력을 담당하는 클래스 입니다.
 *
 * @version 1.0
 */
public class OutputView {

    /**
     * 자동차 이름과 위치를 출력합니다.
     *
     * @param cars 자동차 리스트
     */
    public void printCarNameWithPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition().intValue()));
        }
    }

    /**
     * 새로운 라인을 출력합니다.
     */
    public void printNewLine() {
        System.out.println();
    }

    /**
     * 우승자를 출력합니다.
     *
     * @param carName 우승자 이름
     */
    public void printWinner(String[] carName) {
        if (carName.length == 0) {
            System.out.println("없음");
            return;
        }

        System.out.println(String.join(", ", carName));
    }

    /**
     * 최종 우승자 안내문을 출력합니다.
     */
    public void printFinalWinnerGuide() {
        System.out.print("최종 우승자 : ");
    }
}
