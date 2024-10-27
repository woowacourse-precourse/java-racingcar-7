package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void startOutput() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void racingProgress(final Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getCountAdvance()));
    }

    public void blankLine() {
        System.out.println();
    }

    public void racingResult(final List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
