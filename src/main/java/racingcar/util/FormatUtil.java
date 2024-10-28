package racingcar.util;

import static racingcar.util.UtilConstants.COLON;
import static racingcar.util.UtilConstants.DISTANCE;
import static racingcar.util.UtilConstants.WINNER_DELIMITER;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.WinnerDto;

public class FormatUtil {

    public static String joinCarStatus(CarSnapShot carSnapShot) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(carSnapShot.getName())
                .append(COLON.getValue())
                .append(DISTANCE.getValue().repeat(carSnapShot.getPosition()))
                .toString();
    }

    public static String joinWinners(WinnerDto winners) {
        List<String> winnerNames = winners.names();
        return String.join(WINNER_DELIMITER.getValue(), winnerNames);
    }

}
