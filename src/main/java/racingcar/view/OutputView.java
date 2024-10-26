package racingcar.view;

import static racingcar.message.SystemMessage.*;

import racingcar.dto.CarDto;

public class OutputView {
    public void printResult() {
        System.out.println(GAME_RESULT);
    }

    public void printCurrentResult(CarDto carDto) {
        System.out.println(carDto.toCurrantDistance());
    }

    public void printWinners(CarDto carDto) {
        System.out.println(carDto.toWinners());
    }
}
