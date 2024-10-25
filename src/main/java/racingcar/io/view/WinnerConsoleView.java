package racingcar.io.view;

import racingcar.dto.CarsDto;

public class WinnerConsoleView implements WinnerView {
    private static final String PREFIX = "최종 우승자 : ";
    private static final String LINE_BREAK = "\n";
    private static final WinnerConsoleView INSTANCE = new WinnerConsoleView();

    private WinnerConsoleView() {
    }

    public static WinnerConsoleView getInstance() {
        return INSTANCE;
    }

    @Override
    public void showWinner(CarsDto cars) {
        cars.carDtoList().forEach(car -> System.out.println(PREFIX + car.name() + LINE_BREAK));
    }
}
