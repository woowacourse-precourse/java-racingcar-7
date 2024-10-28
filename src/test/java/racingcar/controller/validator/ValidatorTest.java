package racingcar.controller.validator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("이름이 5자를 초과하는 문자열이 있으면 IllegalArgumentException을 throw한다.")
    void 이름_5자_이상일때_예외_테스트() {
        List<String> nameList = List.of("123456", "123");
        Assertions.assertThatThrownBy(() -> {
            Validator.validateNameList(nameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열이 들어있으면 IlleaglArgumentException을 throw한다.")
    void 빈_문자열_예외_테스트() {
        List<String> nameList = List.of("123456", "123", "");
        Assertions.assertThatThrownBy(() -> {
            Validator.validateNameList(nameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름이 존재하면 IlleaglArgumentException을 throw한다.")
    void 중복_문자열_예외_테스트() {
        List<String> nameList = List.of("12345", "12345");
        Assertions.assertThatThrownBy(() -> {
            Validator.validateNameList(nameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0회 이하의 실행 횟수가 요청되면 IllegalArgumentException을 throw한다")
    void 횟수_요청_예외_테스트() {
        long times = -1;
        Assertions.assertThatThrownBy(() -> {
            Validator.validateTimeInput(times);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}