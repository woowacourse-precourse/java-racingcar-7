package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
  private InputValidator inputValidator;
  @BeforeEach
  void  setUp() {
    inputValidator = new InputValidator();
  }
  @Test
  void  자동차이름_비정상입력_테스트() {
    List<String> carNameInputs = new ArrayList<>();

    carNameInputs.add(null);
    carNameInputs.add("");
    carNameInputs.add("  ");
    carNameInputs.add("pobi , woni , jun");
    carNameInputs.add("pobi;woni;jun");
    carNameInputs.add(",,,,");
    carNameInputs.add(",;,;");

    carNameInputs.forEach((carName) -> {
      assertSimpleTest(() ->
              assertThatThrownBy(() ->
                      inputValidator.validateCarNameInput(carName))
                              .isInstanceOf(IllegalArgumentException.class));
    });
  }
  @Test
  void  시도횟수_비정상입력_테스트() {
    List<String> attemptsInputs = new ArrayList<>();

    attemptsInputs.add(null);
    attemptsInputs.add("");
    attemptsInputs.add("1 2");
    attemptsInputs.add(" 1 2 3 4 ");

    attemptsInputs.forEach((attemptsInput) -> {
      assertSimpleTest(() ->
              assertThatThrownBy(() ->
                      inputValidator.validateAttemptsInput(attemptsInput))
                      .isInstanceOf(IllegalArgumentException.class));
    });
  }
}
