package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarInfo;

public class OutputView {

    public void printRoundResult(List<List<CarInfo>> roundResults) {
        System.out.println("\n실행 결과\n" + formatRoundResults(roundResults));
    }

    public void printWinnerList(List<String> winners) {
        System.out.println("\n최종 우승자 : " + formatWinners(winners));
    }

    public String formatWinners(List<String> winners) {
        if (winners.size() > 1) {
            return String.join(", ", winners);
        } else {
            return String.join("", winners);
        }
    }

    public String formatRoundResults(List<List<CarInfo>> allRoundCarInfos) {
        return allRoundCarInfos.stream()
                .map(carInfos -> carInfos.stream()
                        .map(carInfo -> carInfo.getName() + " : " + "-".repeat(carInfo.getCurrentPosition()))
                        .collect(Collectors.joining("\n"))
                )
                .collect(Collectors.joining("\n\n"));
    }

}
