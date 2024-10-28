package racingcar.ui;

import java.util.List;

public class Winners {

    private final List<Winner> winners;

    public Winners(final List<Winner> winners) {
        this.winners = winners;
    }

    String getResult() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getWinnerName());
            if (i != winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
