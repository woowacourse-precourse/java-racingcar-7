package racingcar.view;

import static racingcar.util.Converter.convertPositionToBar;

import java.util.List;
import racingcar.dto.RoundResult;

public class OutputView {
    public OutputView() {
    }

    public void printRaceResult(List<RoundResult> roundResults) {
        System.out.println("실행 결과");
        for (RoundResult roundResult : roundResults) {
            for (int i = 0; i < roundResult.carNames.size(); i++) {
                String carName = roundResult.carNames.get(i);
                int carPosition = roundResult.carPositions.get(i);
                System.out.println(carName + " : " + convertPositionToBar(carPosition));
            }
            System.out.println();
        }
    }

    public void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String winner : winners) {
            sb.append(winner);
            if (!winner.equals(winners.getLast())) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

}
