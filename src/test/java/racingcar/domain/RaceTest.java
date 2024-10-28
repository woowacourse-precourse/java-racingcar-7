package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.numbergenerator.ExactNumberGenerator;

import java.util.List;

class RaceTest {

    Race race;

    @BeforeEach
    void beforeEach() {
        race = new Race(new ExactNumberGenerator(), List.of("AAA", "BBB", "CCC"));
    }

    @Test
    @DisplayName("3대의 자동차가 모두 매번 전진하면 3대 모두 최종 우승")
    void result() {
        race.run(2);
        String result = "\n실행 결과\nAAA : -\nBBB : -\nCCC : -\n\nAAA : --\nBBB : --\nCCC : --\n\n최종 우승자 : AAA, BBB, CCC";
        Assertions.assertThat(race.result()).isEqualTo(result);
    }
}