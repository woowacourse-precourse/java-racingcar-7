package racingcar.entity;

import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.List;
import java.util.StringJoiner;

public class Winners {
    List<Car> winnerList;

    public Winners(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    // 최종 승자를 반환합니다.
    public String print() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Car car : winnerList) {
            stringJoiner.add(car.toString());
        }
        String result = stringJoiner.toString();
        System.out.println(WINNER_RESULT + result);

        return WINNER_RESULT + result;

    }
}
