package racingcar.utils;

import racingcar.domain.RacingCar;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static racingcar.message.RacingMessage.FINAL_WINNERS;

public class FinalWinnersMessageUtils {

    private static final CharSequence FINAL_WINNERS_DELIMITER = ", ";

    public static String winnersMessage(List<RacingCar> winners) {
        return FINAL_WINNERS.getFormatMessage(winners.stream()
                .map(RacingCar::getName)
                .collect(joining(FINAL_WINNERS_DELIMITER)));
    }
}
