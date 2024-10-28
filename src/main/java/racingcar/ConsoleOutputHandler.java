package racingcar;

import java.util.List;

public class ConsoleOutputHandler {
    private static final RacingSnapshotProvider snapshotProvider = new RacingSnapshotProvider();

    public void showStartComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showCommentForChoosingStageSize() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showSnapshotOfCurrentStage(List<Player> players) {

        players.forEach(
                player -> {
                    System.out.println(snapshotProvider.getSnapshotOf(player));
                }
        );

        System.out.println();
    }

    public void showCommentForResult() {
        System.out.println("실행 결과");
    }

    public void showWinners(List<Player> winners) {

        String result = "최종 우승자 : ";

        for (Player winner : winners) {
            result = result + winner.getName() + ",";
        }

        System.out.println(trimResult(result));

    }

    private static String trimResult(String result) {

        result = result.trim();
        return result.substring(0, result.length() - 1);

    }
}
