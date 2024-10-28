package racingcar.outputview;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarManager;
import racingcar.service.GameManager;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputHandlerTest {


    List<Car> cars;
    @BeforeEach
    public void setUp(){

        cars = new ArrayList<>(Arrays.asList(new Car("a",1), new Car("b", 2), new Car("c", 3)));

    }

    @Test
    void showCurrentCarPosition() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.showCurrentCarPosition(cars);

        assertThat(outputStream.toString().trim()).isEqualTo("a : -" + "\n" + "b : --" + "\n" + "c : ---");
        System.setOut(System.out);




    }

    @Test
    void showWinners() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputHandler outputHandler = new OutputHandler();
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);;
        List<Car> winners  = cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
        outputHandler.showWinners(winners);

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : c");
        System.setOut(System.out);

    }
}