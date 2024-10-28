package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceManagerTest extends NsTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private OutputProcesser outputProcesser;
    private RaceManager raceManager;
    private List<Car> cars;
    private Car pobi;
    private Car woni;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        outputProcesser = new OutputProcesser();
        raceManager = new RaceManager(outputProcesser);
        System.setOut(new PrintStream(outputStreamCaptor));

        cars = new ArrayList<>();
        pobi = new Car("pobi");
        woni = new Car("woni");
    }

    @Test
    void 거리가_0인_경우_경주결과_출력() {
        // given
        cars.add(pobi);
        cars.add(woni);

        // when
        outputProcesser.printRaceResult(cars);

        // then
        String expectedOutput = "pobi : \n" + "woni : \n\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 최종_우승자_1명인_경우() {
        // given
        cars.add(pobi);
        cars.add(woni);

        pobi.addDistance();

        // when
        raceManager.getWinners(cars);

        // then
        assertThat(output().equals("최종 우승자 : pobi"));
    }

    @Test
    void 최종_우승자_여러명인_경우() {
        // given
        cars.add(pobi);
        cars.add(woni);

        pobi.addDistance();
        woni.addDistance();

        // when
        raceManager.getWinners(cars);

        // then
        assertThat(output().equals("최종 우승자 : pobi,woni"));
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}