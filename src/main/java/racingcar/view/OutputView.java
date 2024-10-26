package racingcar.view;

import racingcar.domain.StringConstant;

import java.util.List;

public class OutputView {

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0));

        if (winners.size() == 1) {
            System.out.printf(StringConstant.WINNER_MESSAGE.getValue(), sb);
            return;
        }

        for (int i = 1; i < winners.size(); i++) {
            sb.append(", ").append(winners.get(i));
        }
        System.out.printf(StringConstant.WINNER_MESSAGE.getValue(), sb);

    }
}
