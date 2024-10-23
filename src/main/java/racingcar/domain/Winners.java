package racingcar.domain;

import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.List;
import java.util.StringJoiner;

public class Winners {
    List<Car> winnerList;

    public Winners(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    // 최종 승자를 반환합니다.
    public String result() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Car car : winnerList) {
            String carName = car.toString();
            stringJoiner.add(carName);
        }
        String result = stringJoiner.toString();

        return WINNER_RESULT + result;

    }
}
