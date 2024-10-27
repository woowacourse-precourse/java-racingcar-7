package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceUtils {

    public static String getWinners(final List<Car> carList) {
        List<String> winnerList = new ArrayList<>();

        Collections.sort(carList);
        long maxMoves = carList.get(0).getTotalMoves();

        for (int i = 1; i < carList.size(); i++) {
            if (carList.get(i).getTotalMoves() < maxMoves)
                break;
            winnerList.add(carList.get(i).getName());
        }

        return String.join(", ", winnerList);
    }
}
