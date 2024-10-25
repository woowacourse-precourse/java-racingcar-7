package racingcar.view;

import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public class OutputView {
    private static final String POSITION_MARKER = "-";

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinnersOutput(String winnerMessage) {
        System.out.println("최종 우승자 : " + winnerMessage);
    }

    public static void printRoundResultOutput(CarsDto carsDto) {
        carsDto.getCars().forEach(OutputView::printCarPositionOutput);
        System.out.println();
    }

    private static void printCarPositionOutput(CarDto carDto) {
        System.out.print(carDto.getName() + " : " + POSITION_MARKER.repeat(carDto.getPosition()));
        System.out.println();
    }
}
