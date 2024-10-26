package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;

public class OutputView {

    private static final String HEADER = "\n실행 결과\n";
    private static final String PLAYER_POSITION_TEMPLATE = "%s : %s\n";
    private static final String FOOTER = "\n";
    private static final String ONE_STEP = "-";

    public void printRoundResults(Game game) {
        if (game.isFirstRound()) {
            System.out.printf(HEADER);
        }

        List<Car> players = game.getPlayers();
        for (Car player : players) {
            System.out.printf(PLAYER_POSITION_TEMPLATE, player.getName(), printPosition(player.getPosition()));
        }

        System.out.printf(FOOTER);
    }

    private String printPosition(int position) {
        return ONE_STEP.repeat(position);
    }
}
