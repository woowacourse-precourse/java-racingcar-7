package racingcar.view;

import racingcar.Cars;

import java.util.List;

public abstract class OutputView {

    private OutputView() {
    }

    public static void showRacing(Cars cars) {
        System.out.println("실행 결과 : ");
    }

    public static void showResult(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
