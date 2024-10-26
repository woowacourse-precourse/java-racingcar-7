package racingcar.view;

import static racingcar.constant.OutputMessage.POSITION_MARKER;

import racingcar.constant.OutputMessage;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
    }

    public static void printWinnersOutput(String winnerMessage) {
        System.out.println(OutputMessage.WINNER_MESSAGE.getMessage() + winnerMessage);
    }

    public static void printRoundResultOutput(CarsDto carsDto) {
        carsDto.getCars().forEach(OutputView::printCarPositionOutput);
        System.out.println();
    }

    private static void printCarPositionOutput(CarDto carDto) {
        System.out.print(carDto.getName() + OutputMessage.NAME_POSITION_SEPARATOR.getMessage() + POSITION_MARKER.getMessage().repeat(carDto.getPosition()));
        System.out.println();
    }
}
