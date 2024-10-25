package racingcar.view;

import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;

public class OutputView {

    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public void printMovement(CarsResponse carsResponse) {
        carsResponse.cars().forEach(car -> System.out.println(car.toString()));
    }

    public void printWinner(WinnerResponse response) {
        System.out.print(WINNER_OUTPUT_MESSAGE);
        System.out.println(response.toString());
    }
}
