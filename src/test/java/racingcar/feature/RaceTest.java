package racingcar.feature;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.obj.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class RaceTest {

    Race race = new Race();
    Winner winner = new Winner();

    @Test
    void 경주_출력_테스트() {

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Car car1 = new Car("1번");
        Car car2 = new Car("2번");
        Car car3 = new Car("3번");

        try {
            race.startRace(List.of(car1,car2,car3),5);
            winner.getWinner(List.of(car1,car2,car3));

            String output = outputStream.toString().trim();
            assertThat(output).contains("1번","2번","3번","최종 우승자");
        } finally {
            System.setOut(originalOut);
        }

    }
}
