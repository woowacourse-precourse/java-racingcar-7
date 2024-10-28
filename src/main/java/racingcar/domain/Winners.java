package racingcar.domain;

import static racingcar.utils.Constant.COMMA;

import java.util.List;
import java.util.Objects;
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

    protected String result() {
        StringJoiner stringJoiner = new StringJoiner(COMMA + " ");

        winnerList.forEach(
                car -> stringJoiner.add(
                        car.toString()
                )
        );

        return stringJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners = (Winners) o;
        return Objects.equals(winnerList, winners.winnerList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winnerList);
    }
}
