package racingcar.util;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.WinnerDto;

public class Format {

    public static String joinCarStatus(CarSnapShot carSnapShot) {
        return carSnapShot.getName()
                + " : "
                + "-".repeat(carSnapShot.getPosition());
    }

    public static String joinWinners(WinnerDto winners) {
        List<String> winnerNames = winners.names();
        return String.join(", ", winnerNames);
    }

}
