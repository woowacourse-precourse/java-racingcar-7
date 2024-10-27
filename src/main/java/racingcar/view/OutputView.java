package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();
    private final String RESULT_MESSAGE = "실행 결과";
    private final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private OutputView() {
    }

    ;

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void showRoundResult(Cars cars) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            result = addCarWithNameAndPosition(result, car);
        }
        System.out.println(result.toString());
    }

    private StringBuilder addCarWithNameAndPosition(StringBuilder result, Car car) {
        result.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            result.append('-');
        }
        result.append("\n");
        return result;
    }

    public void showWinners(List<Car> winners) {
        System.out.print(FINAL_WINNER_MESSAGE);
        StringBuilder result = new StringBuilder();
        for (Car winner : winners) {
            result.append(winner.getName()).append(',');
        }
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1); // 마지막 ,(쉼표) 제거
        }

        System.out.println(result.toString());
    }
}
