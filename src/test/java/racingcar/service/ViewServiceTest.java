package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewServiceTest {

    ViewService viewService = new ViewService();

    @DisplayName("자동차 이름이 5자 보다 큰 경우")
    @Test
    void largeCarName(){
        assertThatThrownBy(() -> viewService.inputValidation("가나다라마바,123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1보다 작은 경우")
    @Test
    void countUnderZero(){
        assertThatThrownBy(() -> viewService.countValidation("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 숫자가 아닌 경우")
    @Test
    void numberFormatError(){
        assertThatThrownBy(() -> viewService.countValidation("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}