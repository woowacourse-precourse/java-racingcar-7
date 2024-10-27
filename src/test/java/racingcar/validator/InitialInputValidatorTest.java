package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class InitialInputValidatorTest {
  private InitialInputValidator initialInputValidator;
  @BeforeEach
  void  setUp() {
    initialInputValidator = new InitialInputValidator();
  }
  @Test
  void  초기_비정상입력_테스트() {
    List<String> inputs = new ArrayList<>();

    inputs.add(null);
    inputs.add("");
    inputs.add("  ");
    inputs.add("pobi , woni , jun");
    inputs.add("pobi;woni;jun");
    inputs.add(",,,,");
    inputs.add(",;,;");

    inputs.forEach((input) -> {
      assertSimpleTest(() ->
              assertThatThrownBy(() ->
                      initialInputValidator.validateCarNameInput(input))
                              .isInstanceOf(IllegalArgumentException.class));
    });
  }
}
