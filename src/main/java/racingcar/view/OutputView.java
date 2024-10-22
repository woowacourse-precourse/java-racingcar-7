package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void showResult(final int numOfStages, final List<Car> carList) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < numOfStages; i++)
            showResultInStage(i, carList);
        showWinner();
    }

    private static void showResultInStage(final int numOfStages, final List<Car> carList) {
        for (Car car : carList)
            System.out.println(car.getName() + " : " + car.getMoveHistory().get(numOfStages));
        System.out.println();
    }

    // todo : 우승자가 1명일 때와 2명 이상일 때 구분
    private static void showWinner() {
        System.out.println(WINNER_MESSAGE);
    }
}
