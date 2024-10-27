package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.RaceUtils;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void showResult(final long numOfStages, final List<Car> carList) {
        System.out.println(RESULT_MESSAGE);
        for (long i = 0; i < numOfStages; i++)
            showResultInStage(i, carList);
        showWinner(carList);
    }

    private static void showResultInStage(final long stage, final List<Car> carList) {
        for (Car car : carList)
            System.out.println(car.getName() + " : " + car.getMoveAtStage(stage));
        System.out.println();
    }

    private static void showWinner(final List<Car> carList) {
        String winners = RaceUtils.getWinners(carList);
        System.out.println(WINNER_MESSAGE + winners);
    }
}
