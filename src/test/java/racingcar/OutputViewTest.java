package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView;
    OutputStream outputStream;


    Car pobiCar = new Car("pobi");
    Car woniCar = new Car("woni");

    String pobiMessage = "pobi : ";
    String woniMessage = "woni : ";
    String newLine = "\n";

    @BeforeEach
    void setUp() {
        outputView = new OutputView();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("메세지 출력 테스트")
    public void 메세지_출력_테스트() {
        // given
        String message = "Hello, world!";

        // when
        outputView.println(message);

        // then
        assertThat(outputStream.toString()).isEqualTo(message + newLine);
    }

    @Test
    @DisplayName("printCar 테스트")
    public void printCar_테스트() {
        // when
        outputView.printCar(pobiCar);

        // then
        assertThat(outputStream.toString()).isEqualTo(pobiMessage + newLine);
    }

    @Test
    @DisplayName("printCars 테스트")
    public void printCars_테스트() {
        // given
        List<Car> cars = List.of(pobiCar, woniCar);

        // when
        outputView.printCars(cars);

        // then
        assertThat(outputStream.toString())
                .isEqualTo(pobiMessage + newLine + woniMessage + newLine);
    }


}