package racingcar.view;

import static racingcar.message.SystemMessage.*;

import racingcar.dto.CarDto;

public class OutputView {
    public void printResult() {
        System.out.print(System.lineSeparator());
        System.out.println(GAME_RESULT.getMessage());
    }

    public void printCurrentResult(CarDto carDto) {
        System.out.println(carDto.toCurrantDistance());
        System.out.print(System.lineSeparator());
    }

    public void printWinners(CarDto carDto) {
        System.out.println(carDto.toWinners());
    }
}
