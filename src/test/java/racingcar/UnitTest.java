package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest extends NsTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // 각 테스트 전에 System.in을 복구하기 위해 원본을 저장합니다.
        System.setIn(originalIn);
    }

    @AfterEach
    void restoreSystemIn() {
        // 각 테스트 후에 System.in을 원본으로 복구합니다.
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("getCarInput 테스트")
    void getCarInputTest() {
        final String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = Application.getCarInput();
        assertThat(result).isEqualTo("car1,car2,car3");
    }

    @Test
    @DisplayName("splitInput 작동테스트")
    void splitInputTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        List<RacingCar> resultCars = Application.splitInput("car1,car2,car3");
        assertThat(resultCars).extracting("name").containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("splitInput 글자수 예외테스트")
    void splitInputTest2() {
        assertThatThrownBy(() -> Application.splitInput("car1,car2,car333"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("getTrial 글자수 정상 작동 테스트")
    void getTrialTest() {
        final String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Integer result = Application.getTrial();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("getTrial 예외 테스트")
    void getTrialTest2() {
        final String input = "--\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> Application.getTrial())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("getRandomNumber 테스트")
    void getRandomNumberTest() {
        assertRandomNumberInRangeTest(
                ()->{
                    int result1 = Application.getRandomNumber();
                    int result2 = Application.getRandomNumber();
                    assertThat(result1).isEqualTo(5);
                    assertThat(result2).isEqualTo(7);
                },
                5,7
        );
    }

    @Test
    @DisplayName("assignRandomNumber 테스트")
    void assignRandomNumberTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        assertRandomNumberInRangeTest(
                ()->{Application.assignRandomNumber(cars);
                    assertThat(cars.get(0).randomNumbers).containsExactly(5);
                    assertThat(cars.get(1).randomNumbers).containsExactly(7);
                    assertThat(cars.get(2).randomNumbers).containsExactly(9);
                }, 5, 7, 9
        );
    }

    @Test
    @DisplayName("checkRandomNumber 테스트")
    void checkRandomNumberTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));

        assertRandomNumberInRangeTest(
                ()->{Application.assignRandomNumber(cars);
                assertThat(cars.get(0).randomNumbers).containsExactly(5);
                assertThat(cars.get(1).randomNumbers).containsExactly(3);
                assertThat(cars.get(2).randomNumbers).containsExactly(1);
                }, 5, 3, 1
        );
        Application.checkRandomNumber(cars);
        assertThat(cars.get(0).position).isEqualTo(1);
        assertThat(cars.get(1).position).isEqualTo(0);
        assertThat(cars.get(2).position).isEqualTo(0);
    }

    @Test
    @DisplayName("printCarInfo 테스트")
    void printCarInfoTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        cars.get(0).position = 1; cars.get(1).position = 3; cars.get(2).position = 2;

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.printCarInfo(cars);
        assertThat(out.toString()).contains("car1 : -", "car2 : ---", "car3 : --");
    }

    @Test
    @DisplayName("getWinPosition 테스트")
    void getWinPositionTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        cars.get(0).position = 1; cars.get(1).position = 3; cars.get(2).position = 2;
        assertThat(Application.getWinPosition(cars)).isEqualTo(3);
    }

    @Test
    @DisplayName("getWinners 테스트")
    void getWinnersTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        cars.get(0).position = 1; cars.get(1).position = 3; cars.get(2).position = 2;
        List<String> winners = Application.getWinners(cars, 3);
        for(RacingCar car : cars){
            if(car.position == 3){//3은 maxPosition
                assertThat(winners).contains(car.name);
            }
        }
    }

    @Test
    @DisplayName("printWinners 테스트")
    void printWinnersTest() {
        List<String> winners = new ArrayList<>();
        winners.add("car1");
        winners.add("car2");
        winners.add("car3");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.printWinners(winners);
        assertThat(out.toString()).contains("최종 우승자 : car1, car2, car3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
