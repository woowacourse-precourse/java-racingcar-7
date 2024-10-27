package racingcar.view;

import racingcar.domain.Car;
import racingcar.service.RaceService;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void showResult(RaceService raceService) {
        System.out.println(RESULT_MESSAGE);
        for (long i = 0; i < raceService.getNumOfStages(); i++)
            showResultInStage(i, raceService.getCarList());
        showWinner(raceService.getWinnerList());
    }

    private static void showResultInStage(final long stage, final List<Car> carList) {
        for (Car car : carList)
            System.out.println(car.getName() + " : " + car.getMoveHistoryAtStage(stage));
        System.out.println();
    }

    private static void showWinner(final String winnerList) {
        System.out.println(WINNER_MESSAGE + winnerList);
    }
}
