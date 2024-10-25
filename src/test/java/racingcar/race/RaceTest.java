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
    void 생성자_공백_레이서_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Race(new String[]{""}));
    }

    @Test
    void 생성자_공백_배열_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Race(new String[]{}));
    }

    @Test
    void 레이서_없이_실행(){
        race = new Race();

        assertThrows(IllegalArgumentException.class, () -> race.startRace(5));
    }
}
