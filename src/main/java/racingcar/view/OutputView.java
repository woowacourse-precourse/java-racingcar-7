package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";

    public static void printGame(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerNames.append(", "); // 마지막 요소 뒤에는 쉼표 추가 안 함
            }
        }

        System.out.println(FINAL_RESULT_MESSAGE + winnerNames);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

}

