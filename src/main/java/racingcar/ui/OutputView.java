package racingcar.ui;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.CarSnapshot;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.racing.RacingSnapshot;

public class OutputView {

    public static final String RACING_RESULT_PROMPT = "실행 결과";
    public static final String WINNER_ANNOUNCEMENT_PROMPT = "최종 우승자 : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String DELIMITER = ", ";
    private static final int ZERO = 0;

    public void printRacingResult(RacingResult racingResult) {
        printRacingResultAnnouncement();
        printTotalSnapshot(racingResult.getSnapshots());
        printWinners(racingResult.getWinner());
    }

    private void printRacingResultAnnouncement() {
        System.out.println();
        System.out.println(RACING_RESULT_PROMPT);
    }

    private void printTotalSnapshot(List<RacingSnapshot> racingSnapshots) {
        racingSnapshots.forEach(this::printRacingSnapshot);
    }

    private void printWinners(List<String> winners) {
        System.out.println(MessageFormat.format("{0}{1}", WINNER_ANNOUNCEMENT_PROMPT, String.join(DELIMITER, winners)));
    }

    private void printRacingSnapshot(RacingSnapshot racingSnapshot) {
        List<CarSnapshot> carSnapshots = racingSnapshot.carSnapshots();
        carSnapshots.forEach(this::printCarSnapshot);
        System.out.println();
    }

    private void printCarSnapshot(CarSnapshot carSnapshot) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carSnapshot.name());
        stringBuilder.append(NAME_POSITION_SEPARATOR);
        IntStream.range(ZERO, carSnapshot.position()).forEach(i -> stringBuilder.append(POSITION_SYMBOL));
        System.out.println(stringBuilder);
    }
}
