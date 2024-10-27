package racingcar.view;

import java.util.Map;

public class Output {
    private static final String MOVE_COUNT = "-";
    private static final String ERROR_MESSAGE = "[ERROR] : ";

    public void printRacingResullt(Map<String, Integer> racingResult) {
        System.out.println("실행 결과");
        for (String carName : racingResult.keySet()) {
            System.out.print(carName + " : ");
            System.out.print(MOVE_COUNT.repeat(racingResult.get(carName)));
            System.out.println();
        }
    }

    public void printFinalWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
