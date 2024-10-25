package racingcar.view;

import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;

public class OutputView {

    public static final String RESULT_OUTPUT_MESSAGE = "\n실행 결과";
    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println(RESULT_OUTPUT_MESSAGE);
    }

    public void printMovement(CarsResponse carsResponse) {
        carsResponse.cars()
                .forEach(car -> System.out.println(car.toString()));
    }

    public void printWinner(WinnerResponse response) {
        System.out.printf("%s%s", WINNER_OUTPUT_MESSAGE, response.toString());
    }
}
