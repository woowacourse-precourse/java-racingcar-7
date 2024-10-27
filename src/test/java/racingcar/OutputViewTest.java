package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final LinkedHashMap<Car, Long> carToProgress = new LinkedHashMap<>();
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("test1");
        car2 = new Car("test2");
        car3 = new Car("test3");
        carToProgress.put(car1, 4L);
        carToProgress.put(car2, 3L);
        carToProgress.put(car3, 4L);
    }

    @Test
    void 라운드_별_결과를_확인한다() {

        //given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        outputView.printRoundOutput(carToProgress);

        //then
        String output = outputStream.toString();
        Assertions.assertAll(
                () -> Assertions.assertTrue(output.contains("test1 : ----")),
                () -> Assertions.assertTrue(output.contains("test2 : ---")),
                () -> Assertions.assertTrue(output.contains("test3 : ----"))
        );
    }

    @Test
    void 우승자를_확인한다() {

        //given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> winnerList = new ArrayList<>();
        winnerList.add(car1.getName());
        winnerList.add(car3.getName());

        //when
        outputView.printFinalWinner(winnerList);

        //then
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("test1, test3"));


    }
}
