package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Racing {
    private static final ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
    private static final ConsoleInputHandler inputHandler = new ConsoleInputHandler();
    private static int maxDistance;
    private static int totalStage;

    public void race() {

        outputHandler.showStartComment();
        List<String> names = inputHandler.getUserNameInput();
        List<Player> players = names.stream()
                .map(Player::new)
                .toList();

        outputHandler.showCommentForChoosingStageSize();
        totalStage = inputHandler.getTotalStageSizeInput();

        outputHandler.showCommentForResult();
        startRacing(players);

        List<Player> winners = findWinnerFrom(players);
        outputHandler.showWinners(winners);

    }

    private static void startRacing(List<Player> players) {

        for (int i = 0; i < totalStage; i++) {

            checkAndMove(players);
            outputHandler.showSnapshotOfCurrentStage(players);

        }

    }

    private static void updateMaxDistance(Player player) {
        maxDistance = Math.max(player.getDistance(), maxDistance);
    }

    private static List<Player> findWinnerFrom(List<Player> players) {

        return players.stream()
                .filter(player -> player.isWinner(maxDistance))
                .toList();

    }

    private static void checkAndMove(List<Player> players) {

        for (Player player : players) {

            if (canMoveThisRound()) {
                player.move();
            }

            updateMaxDistance(player);

        }

    }

    private static boolean canMoveThisRound() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;

    }

}
