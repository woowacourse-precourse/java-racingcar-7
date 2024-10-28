package racingcar.util;

import static racingcar.util.UtilConstants.COLON;
import static racingcar.util.UtilConstants.DISTANCE;
import static racingcar.util.UtilConstants.WINNER_DELIMITER;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.WinnerDto;

public class FormatUtil {

    public static String joinCarStatus(CarSnapShot carSnapShot) {
        return carSnapShot.getName()
                + COLON.getValue()
                + DISTANCE.getValue().repeat(carSnapShot.getPosition());
    }

    public static String joinWinners(WinnerDto winners) {
        List<String> winnerNames = winners.names();
        return String.join(WINNER_DELIMITER.getValue(), winnerNames);
    }

}
