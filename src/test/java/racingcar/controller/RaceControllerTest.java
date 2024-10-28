package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RaceService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RaceControllerTest {

    private final RaceService raceService = new RaceService();
    private final RaceController raceController = new RaceController(raceService);
    private final List<Car> cars = new ArrayList<>();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = new PrintStream(outputStream);

    @BeforeEach
    public void setUp() {

        cars.add(new Car("car4",0,4));
        cars.add(new Car("car5",0,4));
        cars.add(new Car("car6",0,3));

        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }


    @Test
    @DisplayName("레이싱 결과 도출 메서드 테스트")
    public void testRacingResult() {

        String jointWinnerResult = "최종 우승자 : car4, car5\n";

        raceController.racingResult(cars);
        assertThat(outputStream.toString()).isEqualTo(jointWinnerResult);

    }

}
