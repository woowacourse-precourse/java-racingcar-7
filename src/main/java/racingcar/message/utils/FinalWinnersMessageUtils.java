package racingcar.message.utils;

import racingcar.domain.RacingCar;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static racingcar.message.RacingMessage.FINAL_WINNERS;
import static racingcar.message.RacingMessage.FINAL_WINNERS_DELIMITER;

public class FinalWinnersMessageUtils {

    public static String generateFinalWinnersMessage(List<RacingCar> winners) {
        return FINAL_WINNERS.getFormatMessage(winners.stream()
                .map(RacingCar::getName)
                .collect(joining(FINAL_WINNERS_DELIMITER)));
    }
}
