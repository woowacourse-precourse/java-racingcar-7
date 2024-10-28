package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.CarImpl;
import racingcar.car.ICar;
import racingcar.display.OutputDisplayImpl;

public class OutputDisplayImplTests {

    private OutputDisplayImpl outputDisplay;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void init() {
        outputDisplay = new OutputDisplayImpl();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void printWinner() {
        List<ICar> carList = new ArrayList<>();
        carList.add(new CarImpl("gana"));

        outputDisplay.printWinners(carList);

        assertThat(outputStream.toString())
                .contains("최종 우승자 : gana");
    }

    @Test
    public void printWinnerList() {
        List<ICar> carList = new ArrayList<>();
        carList.add(new CarImpl("gana"));
        carList.add(new CarImpl("dara"));

        outputDisplay.printWinners(carList);

        assertThat(outputStream.toString())
                .contains("최종 우승자 : gana, dara");
    }

    @Test
    public void printRoundResult() {
        // given
        List<ICar> carList = new ArrayList<>();
        carList.add(new CarImpl("gana"));
        carList.add(new CarImpl("dara"));
        carList.add(new CarImpl("maru"));

        for (int i = 0; i < carList.size(); i++) {
            ICar car = carList.get(i);

            while (car.getPosition() < i) {
                car.drive();
            }
        }

        // when
        outputDisplay.printRoundResult(carList);

        // then
        assertThat(outputStream.toString())
                .contains("gana : ")
                .contains("dara : -")
                .contains("maru : --");
    }
}
