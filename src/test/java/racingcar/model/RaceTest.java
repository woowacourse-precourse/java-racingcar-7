package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class RaceTest {
    @Test
    @DisplayName("자동차 이름과 이동횟수를 입력받아 레이스를 만들 수 있다")
    public void createRaceWithNamesAndCount() {
        Race race = new Race("abc,def", "2");
        assertSoftly(softly -> {
            softly.assertThat(race.getCars().get(0).getName()).isEqualTo("abc");
            softly.assertThat(race.getCars().get(1).getName()).isEqualTo("def");
            softly.assertThat(race.getCount()).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("숫자가 4이상 일 때 전진할 수 있다")
    public void moveForwardIfAtLeastFour() {
        Race race = new Race("abc,def", "2");
        race.getCars().get(0).moveBasedOnPoint(3);
        race.getCars().get(1).moveBasedOnPoint(4);

        assertSoftly(softly -> {
            softly.assertThat(race.getCars().get(0).getPosition()).isEqualTo(0);
            softly.assertThat(race.getCars().get(1).getPosition()).isEqualTo(1);
        });
    }
}
