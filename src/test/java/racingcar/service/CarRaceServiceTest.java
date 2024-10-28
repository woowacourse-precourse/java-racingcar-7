package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.move.MoveGenerator;
import racingcar.printer.Printer;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRaceServiceTest {

    static class StubPrinter implements Printer {
        private final StringWriter stringWriter = new StringWriter();

        @Override
        public void writeProgress(List<Car> cars) {
            try {
                for (Car car : cars) {
                    stringWriter.write(car.getName() + " : ");
                    for (int i = 0; i < car.getLocation(); i++) {
                        stringWriter.write("-");
                    }
                    stringWriter.write("\n");
                }
                stringWriter.write("\n");
            } catch (Exception e) {
                throw new RuntimeException("Printer Error");
            }
        }

        @Override
        public void printProgress() {
            try {
                stringWriter.flush();
            } catch (Exception e) {
                throw new RuntimeException("Printer Error");
            }
        }

        @Override
        public void printMessage(String message) {
            try {
                stringWriter.write(message + "\n");
                stringWriter.flush();
            } catch (Exception e) {
                throw new RuntimeException("Printer Error");
            }
        }

        public String getOutput() {
            return stringWriter.toString();
        }
    }

    @Test
    @DisplayName("정상 진행")
    void success_RaceProgress() {
        // Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int round = 3;

        MoveGenerator moveGenerator = () -> true;

        StubPrinter printer = new StubPrinter();
        CarRaceService service = new CarRaceService(cars, round, moveGenerator, printer);

        // When
        service.startRace();

        // Then
        String expectedOutput =
            "\n실행 결과\n" +
                "pobi : -\nwoni : -\njun : -\n\n" +
                "pobi : --\nwoni : --\njun : --\n\n" +
                "pobi : ---\nwoni : ---\njun : ---\n\n" +
                "최종 우승자 : pobi, woni, jun\n";

        assertThat(printer.getOutput()).isEqualTo(expectedOutput);

        // Additionally, verify locations
        assertThat(car1.getLocation()).isEqualTo(3);
        assertThat(car2.getLocation()).isEqualTo(3);
        assertThat(car3.getLocation()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 단독")
    void success_SingleWinner() {
        // Given
        Car car1 = new Car("pobi"); // 2
        Car car2 = new Car("woni"); // 1
        Car car3 = new Car("jun");  // 1
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int round = 3;

        // Stub MoveGenerator
        MoveGenerator moveGenerator = new MoveGenerator() {
            private int callCount = 0;

            @Override
            public boolean move() {
                callCount++;
                if (callCount <= 4) {
                    return true;
                }
                return false;
            }
        };

        StubPrinter printer = new StubPrinter();
        CarRaceService service = new CarRaceService(cars, round, moveGenerator, printer);

        // When
        service.startRace();

        // Then
        String expectedOutput =
            "\n실행 결과\n" +
                "pobi : -\nwoni : -\njun : -\n\n" +
                "pobi : --\nwoni : -\njun : -\n\n" +
                "pobi : --\nwoni : -\njun : -\n\n" +
                "최종 우승자 : pobi\n";

        assertThat(printer.getOutput()).isEqualTo(expectedOutput);
        assertThat(car1.getLocation()).isEqualTo(2);
        assertThat(car2.getLocation()).isEqualTo(1);
        assertThat(car3.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 공동")
    void success_MultipleWinners() {
        // Given
        Car car1 = new Car("pobi"); // 3
        Car car2 = new Car("woni"); // 3
        Car car3 = new Car("jun");  // 1
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int round = 3;

        // Stub MoveGenerator
        MoveGenerator moveGenerator = new MoveGenerator() {
            private int callCount = 0;

            @Override
            public boolean move() {
                callCount++;
                if (callCount < 6) {
                    return true;
                }
                return false;
            }
        };

        StubPrinter printer = new StubPrinter();

        CarRaceService service = new CarRaceService(cars, round, moveGenerator, printer);

        // When
        service.startRace();

        // Then
        String expectedOutput =
            "\n실행 결과\n" +
                "pobi : -\nwoni : -\njun : -\n\n" +
                "pobi : --\nwoni : --\njun : -\n\n" +
                "pobi : --\nwoni : --\njun : -\n\n" +
                "최종 우승자 : pobi, woni\n";

        assertThat(printer.getOutput()).isEqualTo(expectedOutput);
        assertThat(car1.getLocation()).isEqualTo(2);
        assertThat(car2.getLocation()).isEqualTo(2);
        assertThat(car3.getLocation()).isEqualTo(1);
    }
}