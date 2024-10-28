package racingcar;

import java.util.List;

public class RacingGameOutput {

    private static final String GAME_START_PROMPT = "실행 결과";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_UNIT = "-";
    private static final String WINNER_PROMPT = "최종 우승자 : ";

    private static final StringBuilder sb = new StringBuilder();

    public void printGameStart() {
        System.out.println(GAME_START_PROMPT);
    }

    public void printRacingProgress(RacingGame game, Cars cars) {
        List<RoundResult> roundResults = game.determineRoundResult();
        for (RoundResult roundResult : roundResults) {
            List<Integer> results = roundResult.extractResults();
            printRoundProgress(cars, results);
            printRoundEnd();
        }
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(",", winners);
        System.out.println(WINNER_PROMPT + winnerNames);
    }

    private void printRoundProgress(Cars cars, List<Integer> positions) {
        int numOfCars = cars.getSize();
        for (int index = 0; index < numOfCars; index++) {
            printRaceProgress(cars.getCarName(index), positions.get(index));
        }
    }

    private void printRoundEnd() {
        System.out.println();
    }

    private void printRaceProgress(String carName, int position) {
        sb.setLength(0);  // StringBuilder 초기화
        sb.append(carName)
                .append(NAME_POSITION_SEPARATOR)
                .append(POSITION_UNIT.repeat(position));
        System.out.println(sb);
    }
}
