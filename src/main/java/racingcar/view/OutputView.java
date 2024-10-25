package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public class OutputView {
    private static final String POSITION_MARKER = "-";

    public static void printWinners() {

    }

    public static void printRoundResultOutput(CarsDto carsDto) {
        System.out.println("실행 결과");
        carsDto.getCars().forEach(OutputView::printCarPositionOutput);
    }

    private static void printCarPositionOutput(CarDto carDto) {
        System.out.print(carDto.getName() + " : " + POSITION_MARKER.repeat(carDto.getPosition()));
        System.out.println();
    }
}
