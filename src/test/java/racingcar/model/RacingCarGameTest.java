package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarGameTest {

  CarFactory carFactory = new CarFactory();
  RacingCarGame racingCarGameAfter;
  RacingCarGame racingCarGameBefore;

  @ParameterizedTest
  @ValueSource(ints = {10, 20, 100})
  void 시도횟수만큼_경기를_진행하면_모든_자동차의_전진횟수가_같지_않다(int round) {
    // given
    racingCarGameAfter = new RacingCarGame(carFactory.extractCarNames("pobi,yongE,java,twerk"));
    racingCarGameBefore = new RacingCarGame(carFactory.extractCarNames("pobi,yongE,java,twerk"));
    // when
    for (int i = 0; i < round; i++) {
      racingCarGameAfter.play();
    }
    // then
    Assertions.assertThat(racingCarGameAfter.cars().stream().map(Car::getMoveCount)).isNotEqualTo(racingCarGameBefore.cars().stream().map(Car::getMoveCount));

  }

  @Test
  void 열_번이상_경주를_진행하면_우승자는_0명일_수_없다() {
    // given
    racingCarGameAfter = new RacingCarGame(carFactory.extractCarNames("pobi,yongE,java,twerk"));
    // when
    for (int i = 0; i < 10; i++) {
      racingCarGameAfter.play();
    }
    // then
    Assertions.assertThat(racingCarGameAfter.getWinners().size()).isNotEqualTo(0);
  }

  @Test
  void 우승자가_0명이면_예외를_발생한다() {
    racingCarGameBefore = new RacingCarGame(carFactory.extractCarNames("pobi,yongE,java,twerk"));
    Assertions.assertThatThrownBy(() -> racingCarGameBefore.getWinners()).isInstanceOf(IllegalArgumentException.class);
  }
}
