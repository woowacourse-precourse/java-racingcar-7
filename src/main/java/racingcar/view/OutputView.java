package racingcar.view;

import static racingcar.constant.RacingCarInfoMsg.PRESENTATION_FINAL_WINNER;
import static racingcar.constant.RacingCarInfoMsg.TRACKING_START;
import static racingcar.constant.RacingCarStatic.FINAL_WINNER_SEPARATOR;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void printTrackingStartMsg() {
        System.out.println(TRACKING_START.getMsg());
    }

    public void printRaceProcess(BigInteger raceCount, Map<String, String>[] raceResults) {
        StringBuilder sb = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; raceCount.compareTo(i) > 0; i = i.add(BigInteger.ONE)) {
            int round = i.intValue();
            Set<String> carNames = raceResults[round].keySet();
            for (String carName : carNames) {
                sb.append("%s : %s\n".formatted(carName, raceResults[round].get(carName)));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public void printFinalWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();

        sb.append(PRESENTATION_FINAL_WINNER.getMsg());
        sb.append(String.join(FINAL_WINNER_SEPARATOR, winners));

        System.out.print(sb);
    }
}
