package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    NumberGenerator forwardGenerator = () -> 4;
    NumberGenerator stopGenerator = () -> 3;

    @DisplayName("레이스 생성 성공")
    @Test
    void raceTest() {
        Car pobi = new Car("pobi", forwardGenerator);
        Car woni = new Car("woni", stopGenerator);
        List<Car> cars = List.of(pobi, woni);

        Assertions.assertThatCode(() -> new Race(cars))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이스 생성 실패 : 중복된 자동차 이름")
    @Test
    void validateDuplicatesTest() {
        Car pobi = new Car("pobi", forwardGenerator);
        Car woni = new Car("pobi", stopGenerator);
        List<Car> cars = List.of(pobi, woni);

        Assertions.assertThatThrownBy(() -> new Race(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름의 자동차가 존재합니다.");
    }

    @DisplayName("레이스 생성 실패 : 둘 미만의 자동차가 참가")
    @Test
    void validateAtLeastTwoCarsTest() {
        Car pobi = new Car("pobi", forwardGenerator);
        List<Car> cars = List.of(pobi);

        Assertions.assertThatThrownBy(() -> new Race(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("둘 이상의 자동차가 경주에 참여해야 합니다.");
    }

    @DisplayName("우승자 판별 성공 : 한 명의 우승자")
    @Test
    void findWinnerTest() {
        //given
        Car pobi = new Car("pobi", forwardGenerator);
        Car woni = new Car("woni", stopGenerator);
        List<Car> cars = List.of(pobi, woni);
        Race race = new Race(cars);
        pobi.move();

        //when
        List<Car> winners = race.findWinners();

        //then
        Assertions.assertThat(winners.getFirst()).isEqualTo(pobi);
    }

    @DisplayName("우승자 판별 성공 : 둘 이상의 우승자")
    @Test
    void findWinnersTest() {
        //given
        Car pobi = new Car("pobi", forwardGenerator);
        Car woni = new Car("woni", forwardGenerator);
        List<Car> cars = List.of(pobi, woni);
        Race race = new Race(cars);
        pobi.move();
        woni.move();

        //when
        List<Car> winners = race.findWinners();

        //then
        Assertions.assertThat(winners.getFirst()).isEqualTo(pobi);
        Assertions.assertThat(winners.getLast()).isEqualTo(woni);
    }
}
