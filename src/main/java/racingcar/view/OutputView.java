package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

public class OutputView {

    private static final String HEADER = "\n실행 결과\n";
    private static final String PLAYER_POSITION_TEMPLATE = "%s : %s\n";
    private static final String FOOTER = "\n";
    private static final String ONE_STEP = "-";
    private static final String FINAL_WINNER_TEMPLATE = "최종 우승자 : %s";
    private static final String WINNERS_DELIMITER = ", ";

    public void printRoundResults(RacingGame racingGame) {
        if (racingGame.isFirstRound()) {
            System.out.printf(HEADER);
        }

        List<RacingCar> players = racingGame.getPlayers();
        for (RacingCar player : players) {
            String name = player.getName();
            String position = printPosition(player.getPosition());

            System.out.printf(PLAYER_POSITION_TEMPLATE, name, position);
        }

        System.out.printf(FOOTER);
    }

    private String printPosition(int position) {
        return ONE_STEP.repeat(position);
    }

    public void printFinalWinners(RacingGame racingGame) {
        List<RacingCar> finalWinners = racingGame.findFinalWinners();

        if (finalWinners.size() == 1) {
            printSingleWinner(finalWinners);
        }
        if (finalWinners.size() > 1) {
            printMultipleWinners(finalWinners);
        }
    }

    private void printSingleWinner(List<RacingCar> finalWinners) {
        String name = finalWinners.getFirst().getName();

        System.out.printf(FINAL_WINNER_TEMPLATE, name);
    }

    private void printMultipleWinners(List<RacingCar> finalWinners) {
        List<String> names = finalWinners.stream()
                .map(RacingCar::getName)
                .toList();
        String namesWithDelimiter = String.join(WINNERS_DELIMITER, names);

        System.out.printf(FINAL_WINNER_TEMPLATE, namesWithDelimiter);
    }
}
