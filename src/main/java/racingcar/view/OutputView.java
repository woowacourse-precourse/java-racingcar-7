package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printReportCards(Map<String, boolean[]> carReportCards, int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            for (Map.Entry<String, boolean[]> entry : carReportCards.entrySet()) {
                String carName = entry.getKey();
                boolean[] reportCard = entry.getValue();

                System.out.print(carName + " : ");
                printProgress(reportCard, i);
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printProgress(boolean[] reportCard, int currentTry) {
        for (int i = 0; i <= currentTry; i++) {
            if (reportCard[i]) {
                System.out.print("-");
            }
        }
    }

    public List<String> calculateWinners(Map<String, boolean[]> carReportCards) {
        List<String> winners = new ArrayList<>();
        int maxSuccessCount = -1;

        for (Map.Entry<String, boolean[]> entry : carReportCards.entrySet()) {
            String carName = entry.getKey();
            boolean[] reportCard = entry.getValue();

            int successCount = calculateSuccessCount(reportCard);

            if (successCount > maxSuccessCount) {
                maxSuccessCount = successCount;
                winners.clear();
                winners.add(carName);
            } else if (successCount == maxSuccessCount) {
                winners.add(carName);
            }
        }

        return winners;
    }

    private int calculateSuccessCount(boolean[] reportCard) {
        int successCount = 0;
        for (boolean result : reportCard) {
            if (result) {
                successCount++;
            }
        }
        return successCount;
    }

    public void printWinners(List<String> winners) {
        if (!winners.isEmpty()) {
            System.out.print("최종 우승자 : ");
            System.out.print(String.join(", ", winners));
        }
    }
}