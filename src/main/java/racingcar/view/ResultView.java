package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.winner.Winners;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String WINNER_SENTENCE = "최종 우승자 : ";
    private static final String CAR_MOVE_DELIMITER = " : ";
    private static final String CAR_WINNER_DELIMITER = ", ";
    private static final String MOVE_MARKER = "-";

    private final Cars cars;

    public ResultView(Cars cars) {
        this.cars = cars;
    }

    public void moveCarResultView(int tryCount) {
        System.out.println();
        for(int i=0; i<tryCount; i++) {
            cars.moves(new MoveStrategy());
            makeResultView();
        }
    }

    private void makeResultView() {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + CAR_MOVE_DELIMITER);
            IntStream.range(0, car.getMoveNumber()).forEach(number -> System.out.print(MOVE_MARKER));
            System.out.println();
        }
        System.out.println();
    }

    public void winnerResultView() {
        Winners winners = new Winners(cars);
        List<String> racingGameWinners = winners.getRacingGameWinners();

        System.out.print(WINNER_SENTENCE);
        String result = String.join(CAR_WINNER_DELIMITER, racingGameWinners);
        System.out.println(result);
    }

}
