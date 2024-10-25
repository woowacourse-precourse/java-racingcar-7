package racingcar.domain;

import static racingcar.utils.Constant.COMMA_SEPARATOR;
import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.List;
import java.util.StringJoiner;

public class Winners {
    private final List<Car> winnerList;

    public Winners(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public static Winners from(CarList carList) {
        List<Car> winners = carList.toWinners();

        return new Winners(winners);
    }

    // 최종 승자를 반환합니다.
    public Message result() {
        StringJoiner stringJoiner = new StringJoiner(COMMA_SEPARATOR + " ");

        winnerList.forEach(
                car -> stringJoiner.add(
                        car.toString()
                )
        );

        String result = WINNER_RESULT + stringJoiner;

        return new Message(result);
    }

}
