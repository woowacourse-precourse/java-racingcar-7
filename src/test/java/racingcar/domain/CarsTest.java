package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

class CarsTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(
                List.of("pobi", "jun", "Lim")
        );
    }

    @Test
    void generateObjectTest() {

        //then
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("win 메서드 반환 테스트")
    void winMethodReturnTest() {

        //when
        List<Name> winners = cars.findWinners();

        //then
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동 후 우승자 한명")
    void getSoloWinnerAfterMove() {
        //given
        moveCars(2);

        //when
        List<Name> winners = cars.findWinners();

        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.getFirst().getName()).isEqualTo("Lim");
    }

    @Test
    @DisplayName("이동 후 우승자 다수")
    void getMultiWinnerAfterMove() {
        //given
        moveCars(3);

        //when
        List<Name> winners = cars.findWinners();

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("jun");
        assertThat(winners.get(1).getName()).isEqualTo("Lim");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "lim"})
    @DisplayName("시합 참여자가 2명 미만 경우 예외")
    void lowThanTwoException(String input) {
        //given
        List<String> name = List.of(input);

        //when then
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"lim,lim", "pobi,pobi,lim"})
    @DisplayName("중복 이름 존재할 경우 예외")
    void duplicateNameException(String input) {
        //given
        List<String> names = List.of(input);

        //when then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }

    private void moveCars(int startValue) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            Car car = cars.getCars().get(i);
            car.process(generateRandomValue(i + startValue));
        }
    }

    private int generateRandomValue(int value) {
        return Randoms.pickNumberInRange(value, value);
    }
}
