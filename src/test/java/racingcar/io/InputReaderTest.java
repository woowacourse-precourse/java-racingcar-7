package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class InputReaderTest {

    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    public void 자동차_이름을_순서대로_읽을_수_있다() throws Exception {
        //given
        command("pobi,woni,jun");
        InputReader inputReader = new InputReader();

        //when
        List<Car> cars = inputReader.readCarNames();

        //then
        assertThat(cars).map(Car::getName)
            .containsExactly("pobi", "woni", "jun");
    }
}