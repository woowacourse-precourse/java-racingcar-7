package racingcar;

import java.util.List;

public class RacingGameOutput {

    private static final String GAME_START_PROMPT = "실행 결과";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_UNIT = "-";
    private static final String WINNER_PROMPT = "최종 우승자 : ";

    public void printGameStart() {
        System.out.println(GAME_START_PROMPT);
    }

    public void printRacingProgress(RacingGame game, Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            // TODO: race() 를 output class 에서 하는게 맞는지 고려하기
            List<Integer> positions = game.race();
            printRoundProgress(cars, positions);
            printRoundEnd();
        }
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(",", winners);
        System.out.println(WINNER_PROMPT + winnerNames);
    }

    private void printRoundProgress(Cars cars, List<Integer> positions) {
        int numOfCars = cars.getSize();
        for (int num = 0; num < numOfCars; num++) {
            printRaceProgress(cars.getCarName(num), positions.get(num));
        }
    }

    private void printRoundEnd() {
        System.out.println();
    }

    private void printRaceProgress(String carName, int position) {
        System.out.println(carName + NAME_POSITION_SEPARATOR + POSITION_UNIT.repeat(position));
    }
}
