package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameListValidatorTest {
    @Test
    public void integratedValidation_ValidList_NotError() {
        //Given: 유효한 리스트
        List<String> validCarNames = Arrays.asList("John", "Mike", "Jane");

        //When: 통합 유효성 검증 메서드인 integratedValidation(List<String> carNameList) 호출
        //Then: 에러 발생하지 않음
        CarNameListValidator.integratedValidation(validCarNames);
    }

    @Test
    public void integratedValidation_ListElementEmpty_Error() {
        // Given: 공백 이름이 있는 리스트
        List<String> emptyNameList = Arrays.asList("John", "Jane", "");

        // When: 통합 유효성 검증 메서드인 integratedValidation(List<String> carNameList) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> CarNameListValidator.integratedValidation(emptyNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1글자 이상이어야 합니다.");
    }

    @Test
    public void integratedValidation_ListElementLengthOver_Error() {
        // Given: 길이 제한을 초과한 이름이 있는 리스트
        List<String> lengthOverNameList = Arrays.asList("John", "Jane", "Michael");

        // When: 통합 유효성 검증 메서드인 integratedValidation(List<String> carNameList) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> CarNameListValidator.integratedValidation(lengthOverNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 5글자 이하로 지정해야 합니다.(\"Michael\"이(가) 5글자 초과)");
    }

    @Test
    public void integratedValidation_ListElementDuplicate_Error() {
        // Given: 중복된 이름이 있는 리스트
        List<String> DuplicateNameList = Arrays.asList("John", "Jane", "John");

        // When: 통합 유효성 검증 메서드인 integratedValidation(List<String> carNameList) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> CarNameListValidator.integratedValidation(DuplicateNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 중복됩니다. (\"John\"이(가) 중복됨)");
    }
}