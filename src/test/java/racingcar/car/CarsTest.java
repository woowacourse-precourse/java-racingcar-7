package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
                .hasMessage("이름을 2개 이상 입력해야 합니다.");
    }

    @DisplayName("이름간 중복이 있으면 안된다.")
    @Test
    void validateDuplicatedName() {
        //given
        List<String> names = List.of("apple", "woowa", "apple");


        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 입력하면 안됩니다.");
    }

    @DisplayName("리스트에 빈 문자열이 존재하면 안된다.")
    @Test
    void emptyStringInNameList() {
        //given
        List<String> names = List.of("apple", "", "woowa");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 이름을 입력할 수 없습니다.");
    }

    @DisplayName("이름의 길이는 다섯글자 이하이다.")
    @Test
    void validateNameLength() {
        //given
        List<String> names = List.of("apple", "carrot", "woowa");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5글자 이하만 가능합니다.");
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

}