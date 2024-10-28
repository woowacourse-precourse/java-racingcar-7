package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessage;
import racingcar.validation.CarValidator;

public class CarValidatorTest {

  @Test
  void validateCarNumber_단일_이름_예외_테스트() {

    List<String> singleCarName = List.of("pobi");

    assertThatThrownBy(() -> CarValidator.validateCarNumber(singleCarName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_CAR_NUMBER.getMessage());
  }

  @Test
  void validateCarNumber_여러_이름_정상_테스트() {

    List<String> multipleCarNames = List.of("pobi", "woni");

    assertThatNoException().isThrownBy(() -> CarValidator.validateCarNumber(multipleCarNames));
  }

  @Test
  void validateDuplicateCarName_중복_이름_예외_테스트() {
    List<String> duplicateCarNames = List.of("pobi", "woni", "pobi");

    assertThatThrownBy(() -> CarValidator.validateDuplicateCarName(duplicateCarNames))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_DUPLICATE_CAR_NAME.getMessage());
  }

  @Test
  void validateDuplicateCarName_중복_없는_정상_테스트() {
    List<String> uniqueCarNames = List.of("pobi", "woni");

    assertThatNoException().isThrownBy(() -> CarValidator.validateDuplicateCarName(uniqueCarNames));
  }

  @Test
  void validateCarName_빈_이름_예외_테스트() {
    assertThatThrownBy(() -> CarValidator.validateCarName(" "))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_CAR_NAME_EMPTY.getMessage());
  }

  @Test
  void validateCarName_이름_길이_예외_테스트() {
    assertThatThrownBy(() -> CarValidator.validateCarName("longname"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
  }

  @Test
  void validateCarName_숫자_이름_예외_테스트() {
    assertThatThrownBy(() -> CarValidator.validateCarName("12345"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_CAR_NAME_NUMERIC_ONLY.getMessage());
  }

  @Test
  void validateCarName_특수문자_포함_이름_예외_테스트() {
    assertThatThrownBy(() -> CarValidator.validateCarName("pobi@"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_CAR_NAME_INCLUDE_SPECIAL_CHAR.getMessage());
  }

  @Test
  void validateCarName_정상_이름_테스트() {
    assertThatNoException().isThrownBy(() -> CarValidator.validateCarName("pobi4"));
  }
}
