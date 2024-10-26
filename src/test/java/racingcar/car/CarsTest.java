package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.car.constant.ErrorMessage.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.car.constant.ErrorMessage.NAME_COUNT_ERROR_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("이름이 두개 이상 들어와야 한다.")
    @Test
    void validateNameListSize() {
        //given
        List<String> names = List.of("apple");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_COUNT_ERROR_MESSAGE);
    }

    @DisplayName("이름간 중복이 있으면 안된다.")
    @Test
    void validateDuplicatedName() {
        //given
        List<String> names = List.of("apple", "woowa", "apple");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAME_ERROR_MESSAGE);
    }

    @DisplayName("정상적인 문자열 리스트가 들어올 경우 이름 수에 맞는 자동자 인스턴스를 가진 일급 컬렉션을 생성한다.")
    @Test
    void createCars() {
        //given
        List<String> names = List.of("apple", "woowa", "kakao");

        //when
        Cars cars = new Cars(names);

        //then
        assertThat(cars.carCount()).isEqualTo(names.size());
    }

    @DisplayName("경주에서 가장 많이 움직인 자동차들의 이름을 반환해야 한다.")
    @Test
    void getWinner() {
        //given
        List<String> names = List.of("apple", "woowa", "kakao");
        Cars cars = new Cars(names);
        List<Integer> randomNumbers = List.of(2, 4, 1);
        cars.attemptMovingAllCars(randomNumbers);

        //when
        List<String> winnerNames = cars.getWinnerNames();

        //then
        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames).contains("woowa");
    }

}