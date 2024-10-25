package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race = new Race();

    @BeforeEach
    void setUp() {
        race = new Race(new String[]{"Test", "Case", "List"});
    }

    @Test
    void 레이스_생성_테스트() {
        List<Racer> racers = race.getRacers();

        assertThat(racers.size()).isEqualTo(3);
    }

    @Test
    void 공백_레이서_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Race(new String[]{""}));
    }

    @Test
    void 공백_문자열_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Race(new String[]{}));
    }
}
