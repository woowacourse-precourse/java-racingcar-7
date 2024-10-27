package racingcar.io;

import racingcar.data.GameData;
import racingcar.data.RoundData;

public class OutputHandler {

    public void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printCarsRacingResult(GameData gameData) {
        System.out.println();
        System.out.println("실행 결과");

        gameData.getRoundData().forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundData roundData) {
        roundData.getResult().forEach(result -> {
            String moveVisualization = "-".repeat(result.getMoveCount());
            System.out.println(result.getCarName() + " : " + moveVisualization);
        });
        System.out.println();
    }
}
