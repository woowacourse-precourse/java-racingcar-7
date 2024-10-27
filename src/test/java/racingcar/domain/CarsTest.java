package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarsRequest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("유효한 자동차 이름 리스트로 CarsRequest가 생성된다.")
    @Test
    void canCreateCarsRequest() {
        //given
        List<CarName> carNames = List.of(new CarName("a"), new CarName("b")); // 유효한 이름
        //when
        CarsRequest carsRequest = new CarsRequest(carNames);
        //then
        assertThat(carsRequest.cars()).hasSize(2);
    }

    @DisplayName("자동차 수가 1대 이하일 경우 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCarsCountIsBelowMinimum() {
        //given
        List<CarName> carNames = List.of(new CarName("a"));
        //when
        //then
        assertThatThrownBy(() -> new CarsRequest(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2명부터 최대 10명까지 경주가 가능합니다."); // 예외 메시지
    }

    @DisplayName("자동차 수가 10대 이상일 경우 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCarsCountIsAboveMaximum() {
        //given
        List<CarName> carNames = createCarNameListWithMoreThanTen();
        //when
        //then
        assertThatThrownBy(() -> new CarsRequest(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2명부터 최대 10명까지 경주가 가능합니다."); // 예외 메시지
    }

    @DisplayName("중복된 자동차 이름이 있는 경우 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCarNamesAreDuplicated() {
        //given
        List<CarName> carNames = List.of(new CarName("dd"), new CarName("dd"));
        //when
        //then
        assertThatThrownBy(() -> new CarsRequest(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 존재합니다."); // 예외 메시지
    }

    private List<CarName> createCarNameListWithMoreThanTen() {
        List<CarName> carNames = new ArrayList<>();
        String[] names = {"하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덟", "아홉", "열", "열하나"};

        for (String name : names) {
            carNames.add(new CarName(name));
        }
        return carNames;
    }
}