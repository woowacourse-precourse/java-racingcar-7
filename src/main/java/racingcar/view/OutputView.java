package racingcar.view;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.car.Count;

public class OutputView {

    public static final String FINAL_WINNER_PREFIX = "최종 우승자 : ";
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_HEADER = "\n실행 결과";
    private static final String RACING_RESULT_BODY = "%s : %s\n";
    private static final String CAR_POSITION_SIGN = "-";
    public static final String FINAL_WINNERS_SEPARATOR = ", ";

    public void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    public void requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);
    }

    public void printGameResult(Cars cars, Count tryCount) {
        System.out.println(RACING_RESULT_HEADER);

        for (int currentCount = 0; currentCount < tryCount.getValue(); currentCount++) {
            printCarsNameAndPosition(cars);
            System.out.println();
        }
    }

    public void printWinner(Cars cars) {
        List<String> winners = cars.getWinners();
        System.out.printf(FINAL_WINNER_PREFIX + String.join(FINAL_WINNERS_SEPARATOR, winners));
    }

    private void printCarsNameAndPosition(Cars cars) {
        List<Car> movedCars = cars.moves();
        for (Car movedCar : movedCars) {
            String name = movedCar.getName();
            int position = movedCar.getPosition();

            System.out.printf(RACING_RESULT_BODY, name, CAR_POSITION_SIGN.repeat(position));
        }
    }
}
