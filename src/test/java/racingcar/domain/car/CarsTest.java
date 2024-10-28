package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private List<String> nameValues;

    @BeforeEach
    void setUp() {
        nameValues = new ArrayList<>(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("자동차들의 이름에 중복이 없으면 자동차들이 생성된다")
    @Test
    void 자동차들_생성_성공() {
        assertDoesNotThrow(() -> Cars.from(nameValues));
    }

    @DisplayName("경주 참가자가 없으면 자동차들 생성에 실패한다")
    @Test
    void 자동차들_생성_실패_참가자_없음() {
        assertThatThrownBy(() -> Cars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 존재하지 않습니다.");
    }

    @DisplayName("자동차들의 이름에 중복이 존재하면 자동차들 생성에 실패한다")
    @Test
    void 자동차들_생성_실패_중복_이름_존재() {
        nameValues.add("pobi");

        assertThatThrownBy(() -> Cars.from(nameValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 자동차 이름을 입력해주세요.");
    }

    @DisplayName("자동차들은 순서대로 값을 받아 순서대로 움직인다")
    @MethodSource("provideNumbersAndExpectedPositions")
    @ParameterizedTest
    void 자동차들_움직임(List<Integer> numbers, List<Integer> expectedPositions) {
        Cars cars = Cars.from(nameValues);

        cars.moveAll(numbers);

        assertThat(cars.getCars().stream()
                .map(Car::position)
                .map(Position::value)
                .toList()
        ).isEqualTo(expectedPositions);
    }

    static Stream<Arguments> provideNumbersAndExpectedPositions() {
        return Stream.of(
                Arguments.of(List.of(4, 3, 4), List.of(1, 0, 1)),
                Arguments.of(List.of(3, 4, 3), List.of(0, 1, 0))
        );
    }

    @DisplayName("조회를 위해 반환한 자동차들은 수정이 불가능하다")
    @Test
    void 조회를_위한_자동차들_복사본_수정_불가() {
        Cars cars = Cars.from(nameValues);

        List<Car> copyCars = cars.getCars();

        assertThatThrownBy(copyCars::removeFirst)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("주어진 위치와 동일한 위치의 자동차 이름들을 반환한다")
    @Test
    void 동일한_위치의_자동차_이름들_반환() {
        Position one = Position.from(1);
        Cars cars = Cars.from(nameValues);
        cars.moveAll(List.of(4, 3, 3)); // pobi 이동

        assertThat(cars.getSamePositionCarNames(one)).containsExactly(Name.from("pobi"));
    }

}
