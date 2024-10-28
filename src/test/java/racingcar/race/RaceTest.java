package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race;

    @BeforeEach
    void setUp() {
        race = new Race(new ArrayList<String>(){{
                add("Test");
                add("Case");
                add("List");
        }});
    }

    @Test
    void 레이스_생성_테스트() {
        List<Racer> racers = race.getRacers();

        assertThat(racers.size()).isEqualTo(3);
    }

    @Test
    void 레이스_진행횟수_테스트(){
        assertThrows(IllegalArgumentException.class, () -> race.startRace(0));
        assertThrows(IllegalArgumentException.class, () -> race.startRace(-1));
        assertThrows(IllegalArgumentException.class, () -> race.startRace(-111));
    }

    @Test
    void 생성자_공백_레이서_테스트(){
        List<String> names = new ArrayList<>();
        names.add("");
        names.add("Test");
        names.addFirst("");
        Race race = new Race(names);

        List<Racer> racers = race.getRacers();

        String[] expectedName = {"C1", "C2", "Test"};
        int idx = 0;g

        for(Racer racer : racers) {
            assertThat(racer.getName()).isEqualTo(expectedName[idx++]);
        }
    }

    @Test
    void 생성자_공백_배열_테스트(){
        List<String> names = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> new Race(names));
    }

    @Test
    void 레이서_없이_실행(){
        race = new Race();

        assertThrows(IllegalArgumentException.class, () -> race.startRace(5));
        assertThrows(IllegalArgumentException.class, () -> race.startRace(3));
    }
}
