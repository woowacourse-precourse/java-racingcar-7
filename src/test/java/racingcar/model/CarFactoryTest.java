package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarFactoryTest {

  @ParameterizedTest
  @ValueSource(strings = {"con@kim,poi", "pobi,,yongE" , "pobi,.yongE"})
  void 자동차이름_파라미터를_구분자_기준으로_검사한다(String input) {
    Assertions.assertThatThrownBy(() -> new CarFactory().extractCarNames(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi", "pobi,java,java", ""})
  void 자동차이름을_검사한다(String input) {
    Assertions.assertThatThrownBy(() -> new CarFactory().extractCarNames(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi,yongE", "pobi, yongE"})
  void 경주에_참가하는_자동차의_갯수가_올바른지_확인한다(String input) {
    // given
    CarFactory carFactory = new CarFactory();
    List<Car> cars = carFactory.extractCarNames(input);
    // when
    List<String> carNames = cars.stream().map(Car::getCarName).toList();
    // then
    Assertions.assertThat(carNames).isEqualTo(List.of("pobi", "yongE"));
  }
}
