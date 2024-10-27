package racingcar.io.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.stream.Collectors;

public class WinnerConsoleView implements WinnerView {
    private static final String PREFIX = "최종 우승자 : ";
    private static final String DELIMITER = ", ";
    private static final WinnerConsoleView INSTANCE = new WinnerConsoleView();

    private WinnerConsoleView() {
    }

    public static WinnerConsoleView getInstance() {
        return INSTANCE;
    }

    @Override
    public void showWinner(CarsDto cars) {
        System.out.println(generateWinningMessage(cars));
    }

    private String generateWinningMessage(CarsDto cars) {
        return PREFIX + generateCarNames(cars);
    }

    private String generateCarNames(CarsDto cars) {
        return cars.carDtoList()
                .stream()
                .map(CarDto::name)
                .collect(Collectors.joining(DELIMITER));
    }
}
