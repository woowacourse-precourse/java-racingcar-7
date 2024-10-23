package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

  @ParameterizedTest
  @ValueSource(strings = {"con@kim,poi", "pobi,,woni" , "pobi,.woni"})
  void 자동차이름_파라미터를_구분자_기준으로_검사한다(String input) {
    Assertions.assertThatThrownBy(() -> new Cars(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi", "pobi,java,java", ""})
  void 자동차이름을_검사한다(String input) {
    Assertions.assertThatThrownBy(() -> new Cars(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi,woni"})
  void 경주에_참가하는_자동차의_갯수를_반환하고_확인한다(String input) {
    // given
    Cars cars = new Cars(input);
    // when
    List<String> carNames = cars.getCars();
    // then
    Assertions.assertThat(carNames).isEqualTo(List.of("pobi", "woni"));
  }
}
