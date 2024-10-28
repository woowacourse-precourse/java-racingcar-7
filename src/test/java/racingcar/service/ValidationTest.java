package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    @DisplayName("5자 초과 시 테스트")
    void carNameOverTheFiveTest() {
        Validation validation = new Validation();
        List<String> carNames = new ArrayList<>();
        carNames.add("bon");
        carNames.add("han");
        carNames.add("seonghyeon");
        carNames.add("over");

        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () ->{
            validation.validateString(carNames);
        });
        assertThat(err.getMessage()).isEqualTo("자동차 이름이 5자를 넘었습니다.");
    }

    @Test
    @DisplayName("이름 중복 테스트")
    void carNameDuplicationTest() {
        Validation validation = new Validation();
        List<String> carNames = new ArrayList<>();
        carNames.add("han");
        carNames.add("han");
        carNames.add("van");
        carNames.add("over");

        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () ->{
            validation.validateString(carNames);
        });
        assertThat(err.getMessage()).isEqualTo("자동차 이름이 중복 되었습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백일 때 테스")
    void carNameIsEmptyTest() {
        Validation validation = new Validation();
        List<String> carNames = new ArrayList<>();
        carNames.add("han");
        carNames.add(" ");
        carNames.add("van");
        carNames.add("over");

        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () ->{
            validation.validateString(carNames);
        });
        assertThat(err.getMessage()).isEqualTo("자동차 이름이 공백으로 입력되었습니다.");
    }
}