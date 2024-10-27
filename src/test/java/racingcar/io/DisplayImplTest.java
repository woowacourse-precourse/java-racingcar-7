package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class DisplayImplTest {

    final ByteArrayOutputStream CUSTOM_OUTPUT_STREAM = new ByteArrayOutputStream();
    final PrintStream STANDARD_OUT = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(CUSTOM_OUTPUT_STREAM));
    }

    @AfterEach
    void tearDown() {
        System.setOut(STANDARD_OUT);
    }

    @Test
    public void 게임의_과정을_출력할_수_있다() throws Exception {
        //given
        DisplayImpl display = new DisplayImpl();
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        cars.get(0).forward(() -> true);
        cars.get(1).forward(() -> false);
        cars.get(2).forward(() -> true);

        //when
        display.progress(cars);

        //then
        String expect = "A : -\nB : \nC : -\n\n";
        assertThat(CUSTOM_OUTPUT_STREAM.toString()).isEqualTo(expect);
    }

    @Test
    public void 게임의_우승자를_출력할_수_있다() throws Exception {
        //given
        DisplayImpl display = new DisplayImpl();
        List<Car> winners = List.of(new Car("A"), new Car("C"));

        //when
        display.winners(winners);

        //then
        String expect = "최종 우승자 : A, C\n";
        assertThat(CUSTOM_OUTPUT_STREAM.toString()).isEqualTo(expect);
    }
}