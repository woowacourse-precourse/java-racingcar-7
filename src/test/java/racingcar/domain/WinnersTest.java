package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class WinnersTest extends NsTest {
    @Test
    void 우승한_자동차가_1대일_때_우승자_테스트() {
        Cars cars = Cars.from(List.of(Car.from("우테코"), Car.from("프리코스")));
        assertRandomNumberInRangeTest(
                () -> {
                    cars.getCars().forEach(Car::move);
                },
                3, 4
        );
        Winners winners = Winners.from(cars);
        List<String> winnersBoard = winners.getWinners().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersBoard).isEqualTo(List.of("프리코스"));
    }

    @Test
    void 우승한_자동차가_여러대일_때_우승자_테스트() {
        Cars cars = Cars.from(List.of(Car.from("우테코"), Car.from("프리코스"), Car.from("화이팅")));
        assertRandomNumberInRangeTest(
                () -> {
                    cars.getCars().forEach(Car::move);
                },
                3, 4, 9
        );
        Winners winners = Winners.from(cars);
        List<String> winnersBoard = winners.getWinners().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersBoard).isEqualTo(List.of("프리코스", "화이팅"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
