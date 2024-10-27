package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String SCAN_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SCAN_TRY_OUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private static final String START_RACE_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printScanCarsMessage(){
        System.out.println(SCAN_CARS_MESSAGE);
    }

    public void printTryOutCountMessage(){
        System.out.println(SCAN_TRY_OUT_COUNT_MESSAGE);
    }

    public void printStartRaceMessage() {
        System.out.println(START_RACE_MESSAGE);
    }

    public void printRaceResult(String raceResult) {
        System.out.println(raceResult);
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);
        System.out.println(FINAL_WINNER + winnerNames);
    }
}
