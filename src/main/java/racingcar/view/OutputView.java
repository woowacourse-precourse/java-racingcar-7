package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.GameStatistics;
import racingcar.domain.RankingEntry;
import racingcar.util.GameConstants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printGameStart() {
        System.out.println("자동차 경주 게임을 시작합니다.");
        System.out.println("============================");
    }

    public void printGameProgress() {
        System.out.println("\n실행 결과");
    }

    public void printRoundStart(int roundNumber) {
        System.out.printf("\n[Round %d]%n", roundNumber);
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car ->
                System.out.printf("%s : %s%n", car.getName(), car.getPositionDisplay())
        );
    }

    public void printProgressBar(String progressBar) {
        System.out.println("\n진행률: " + progressBar);
    }

    public void printCurrentRankings(List<RankingEntry> rankings) {
        System.out.println("\n현재 순위:");
        printRankings(rankings);
    }

    public void printGameStatistics(GameStatistics statistics) {
        System.out.println("\n게임 통계");
        System.out.println("------------------------");
        System.out.printf("총 라운드: %d%n", statistics.getTotalRounds());
        System.out.printf("평균 전진율: %.1f%%%n", statistics.getAverageForwardRate());
        System.out.printf("최대 연속 전진: %d번%n", statistics.getMaxConsecutiveForwards());
        System.out.println("------------------------");
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\n최종 우승자 : " + winnerNames);
    }

    public void printFinalRankings(List<RankingEntry> rankings) {
        System.out.println("\n최종 순위:");
        printRankings(rankings);
    }

    private void printRankings(List<RankingEntry> rankings) {
        for (int i = 0; i < rankings.size(); i++) {
            RankingEntry entry = rankings.get(i);
            System.out.printf("%d. %s (%d칸)%n",
                    i + 1,
                    entry.getName(),
                    entry.getPosition());
        }
    }

    public void printError(String message) {
        System.out.println(GameConstants.ERROR_PREFIX + message);
    }
}
