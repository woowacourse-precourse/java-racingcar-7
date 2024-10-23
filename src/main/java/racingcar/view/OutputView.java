package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String GAME_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";


    public void printGameResult(Cars cars) {
        System.out.println(GAME_MESSAGE);
        cars.getCarList().forEach(
                car -> System.out.println(car.getName() + " : " + '-' * car.getDistance())
        );
    }

    public void printWinner() {
    }

}
