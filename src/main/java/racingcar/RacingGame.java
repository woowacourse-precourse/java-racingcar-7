package racingcar;

import java.util.List;
import java.util.Map;

public class RacingGame {
    private Map<Car, Integer> scoreNum;
    private final UserInterface printoutput;
    public RacingGame() {
        this.printoutput = new UserInterface();
    }
    public void start() {
        final String[] carNames = printoutput.getCarNames();
        scoreNum = initScore(carNames);
        final GameManage loopCount = GameManage.of(printoutput.getOperationCount());

        printoutput.printRacingresult();

        for (int round = 0; round < loopCount.getValue(); round++) {
            Round();
        }
        List<String> winners = victory(scoreNum);
        printoutput.printVictory(winners);

        printoutput.closeConsole();
    }
    private void Round() {
        scoreNum.forEach((key, value) -> {
            int count = regulate(Randoms.pickNumberInRange(0,9));
            printoutput.printScore(key.getName(), count);
            scoreNum.put(key,value+count);
        });
        printoutput.printNewLine();
    }
    private List<String> victory(final Map<Car, Integer> scoreNum) {
        final int maxCount = scoreNum.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
        return scoreNum.entrySet().stream()
                .filter(entry -> entry.getValue() >= maxCount)
                .map(entry -> entry.getKey().getName())
                .toList();
    }


}

