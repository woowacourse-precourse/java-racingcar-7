package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 정상적인_입력() {
        List<String> carNames = List.of("good0", "good1");
        Cars cars = new Cars(carNames);

        var carList = cars.getCars();

        assertThat(carList.get(0).getCarName()).isEqualTo("good0");
        assertThat(carList.get(1).getCarName()).isEqualTo("good1");
    }

    @Test
    void 중복되는_자동차_이름이_있다면_예외처리() {
        List<String> carNames = List.of("dup", "dup", "bad");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승자_판별() {
        Cars cars = new Cars(List.of("a", "b", "c"));
        PlayCount playCount = new PlayCount("1");

        Race race = new Race(new OutputView());
        assertRandomNumberInRangeTest(() -> {
                    race.play(cars, playCount);
                },
                4, 3, 0
        );

        var winners = cars.getWinners();
        assertThat(winners.getFirst()).isEqualTo("a");
    }

    @Test
    void 우승자가_여러명일_경우_판별() {
        Cars cars = new Cars(List.of("a", "b", "c"));
        PlayCount playCount = new PlayCount("1");

        Race race = new Race(new OutputView());
        assertRandomNumberInRangeTest(() -> {
                    race.play(cars, playCount);
                },
                9, 4, 4
        );

        List<String> winners = cars.getWinners();
        assertThat(winners.get(0)).isEqualTo("a");
        assertThat(winners.get(1)).isEqualTo("b");
        assertThat(winners.get(2)).isEqualTo("c");
    }

}