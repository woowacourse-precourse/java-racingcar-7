package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.car.constant.ErrorMessage.DUPLICATED_NAME_ERROR_MESSAGE;
import static racingcar.car.constant.ErrorMessage.NAME_COUNT_ERROR_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void rollback() {
        System.setOut(standardOut);
    }

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

    @DisplayName("최종 우승자가 한명이면 “최종 우승자 : 우승자_이름” 형태로 출력한다")
    @Test
    void printWinner() {

        //given
        List<String> names = List.of("apple", "woowa", "kakao");
        Cars cars = new Cars(names);
        String winner = "woowa";
        List<Integer> randomNumbers = List.of(3, 4, 1);
        cars.attemptMovingAllCars(randomNumbers);
        cars.showAllCarsStatus();

        //when
        cars.showWinner();
        String result = getOutput();

        //then
        assertThat(result).contains("최종 우승자 : " + winner);
    }

    @DisplayName("최종 우승자가 두명 이상이면 우승자 이름 사이 콤마와 공백이 포함된 문자열이 출력된다.")
    @Test
    void printWinners() {

        //given
        List<String> names = List.of("apple", "woowa", "kakao");
        Cars cars = new Cars(names);
        String winner1 = "woowa";
        String winner2 = "kakao";
        List<Integer> randomNumbers = List.of(3, 4, 4);
        cars.attemptMovingAllCars(randomNumbers);
        cars.showAllCarsStatus();

        //when
        cars.showWinner();
        String result = getOutput();

        //then
        assertThat(result).contains("최종 우승자 : " + winner1 + ", " + winner2);
    }

    private String getOutput() {
        return captor.toString().trim();
    }

}