package racingcar;

import java.util.List;

public class OutputView {
    private final static String GAME_PROCESS_RESULT_PHRASE = "실행 결과";
    private final static String WINNER_RESULT_PHRASE = "최종 우승자 : ";

    public static void result(RacingGame racingGame) {
        showGameProcessEachRound(racingGame);
        showWinner(racingGame);
    }

    private static void showWinner(RacingGame racingGame) {
        StringBuilder sb = new StringBuilder(WINNER_RESULT_PHRASE);
        for (Car winner : racingGame.getWinners()) {
            sb.append(winner.getName());
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void showGameProcessEachRound(RacingGame racingGame) {
        System.out.println();
        System.out.println(GAME_PROCESS_RESULT_PHRASE);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        List<RacingGameRecord> records = racingGame.getRecords();
        for (RacingGameRecord record : records) {
            count++;

            Car car = record.getCarLocation();
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(car.currentLocation());
            sb.append("\n");
            if (count % racingGame.countCars() == 0) {
                sb.append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
