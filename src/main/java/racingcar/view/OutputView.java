package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String GAME_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameResult(Cars cars) {
        printMessage(GAME_MESSAGE);
        cars.getCarList().forEach(
                car -> System.out.println(car.getName() + " : " + '-' * car.getDistance())
        );
    }

    public void printWinner() {
    }

}
