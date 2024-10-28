package racingcar.view;

import java.util.List;
import racingcar.enums.StringPattern;
import racingcar.model.RacingCar;

public class OutputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_TURN = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_VIEWPOINT = "최종 우승자 : ";

    public void requestCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public void requestNumberOfTurn() {
        System.out.println(INPUT_NUMBER_OF_TURN);
    }


    public void printResultOfTurn(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            String carName = car.getCarName();
            int currentPosition = car.getCurrentPosition();
            System.out.println(carName + StringPattern.TURN_RESULT_MARK.getValue() + StringPattern.MOVE_MARK.getValue()
                    .repeat(currentPosition));
        }
        System.out.println("\n");
    }

    public void printWinner(List<RacingCar> winners) {
        List<String> winnersName = winners.stream().map(RacingCar::getCarName).toList();
        String result = WINNER_VIEWPOINT + joinWinners(winnersName);
        System.out.println(result);
    }

    private String joinWinners(List<String> winners) {
        return String.join(StringPattern.CAR_NAME_DELIMITER.getValue(), winners);
    }
}
