package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String CLONE_STRING_FORMAT = " : ";
    private static final String MOVE_EXPRESSION = "-";
    private static final String WINNER_PROMPT = "최종 우승자 : ";
    private static final String RACING_START_PROMPT = "실행 결과";

    public void printRacingStart() {
        System.out.println();
        System.out.println(RACING_START_PROMPT);
    }

    public void printStageResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + CLONE_STRING_FORMAT + getMoveDistance(car.getPosition()));
        }
        System.out.println();
    }

    private String getMoveDistance(int position) {
        String moveDistance = "";
        for (int i = 0; i<position; i++) {
            moveDistance += MOVE_EXPRESSION;
        }
        return moveDistance;
    }


    // TODO: 최종 우승 자동차를 출력한다.
}
