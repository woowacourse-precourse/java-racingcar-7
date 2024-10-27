package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest extends NsTest {

    @Test
    @DisplayName("readInput 테스트")
    void readInputTest() {
        String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = Application.readInput();
        assertThat(result).isEqualTo("car1,car2,car3");
    }

    @Test
    @DisplayName("splitInput 작동테스트")
    void splitInputTest() {
        List<RacingCar> resultCars = Application.splitInput("car1,car2, car3");
        assertThat(resultCars).extracting("name").containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("splitInput 같은 이름이 있을 경우")
    void slitInputTest2() {
        assertThatThrownBy(() -> Application.splitInput("car1,car2,car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 이름을 가진 차종을 입력하실 수 없습니다.");
    }

    @Test
    @DisplayName("splitInput 길이 5이상 자동차 있는 경우")
    void slitInputTest3() {
        assertThatThrownBy(() -> Application.splitInput("car1,car2,car333"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 4자 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,4", "5,5", "10000,10000"})
    @DisplayName("parseTrial 글자수 정상 작동 테스트")
    void parseTrialTest(String input, int realTrial) {
        Integer result = Application.parseTrial(input);
        assertThat(result).isEqualTo(realTrial)
                .isPositive();
    }

    @ParameterizedTest
    @ValueSource(strings = {"--", "dkssdu", "asdfasdf", "!"})
    @DisplayName("parseTrial 예외 테스트")
    void parseTrialTest2(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> Application.parseTrial(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkCarName 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car123", "carcar", "asdfasdf123, 안녕"})
    void checkCarNameTest(String carName) {
        assertThatThrownBy(() -> Application.checkCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("getRandomNumber 테스트")
    @CsvSource({"5, 7", "1, 2", "0, 0"})
    void getRandomNumberTest(int randomNumber1, int randomNumber2) {
        assertRandomNumberInRangeTest(
                () -> {
                    int result1 = Application.getRandomNumber();
                    int result2 = Application.getRandomNumber();
                    assertThat(result1).isEqualTo(randomNumber1);
                    assertThat(result2).isEqualTo(randomNumber2);
                },
                randomNumber1, randomNumber2
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("assignRandomNumber 테스트")
    void assignRandomNumberTest(List<RacingCar> cars) {
        assertRandomNumberInRangeTest(
                () -> {
                    Application.assignRandomNumber(cars);
                    assertThat(cars.get(0).randomNumbers).containsExactly(5);
                    assertThat(cars.get(1).randomNumbers).containsExactly(7);
                    assertThat(cars.get(2).randomNumbers).containsExactly(9);
                }, 5, 7, 9
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("checkRandomNumber 테스트")
    void checkRandomNumberTest(List<RacingCar> cars) {
        assertRandomNumberInRangeTest(
                () -> {
                    Application.assignRandomNumber(cars);
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

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("printCarInfo 테스트")
    void printCarInfoTest(List<RacingCar> cars) {
        cars.get(0).position = 1;
        cars.get(1).position = 3;
        cars.get(2).position = 2;

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.printCarInfo(cars);
        assertThat(out.toString()).contains(cars.get(0).name + " : -",
                cars.get(1).name + " : ---", cars.get(2).name + " : --");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("getWinPosition 테스트")
    void getWinPositionTest(List<RacingCar> cars) {
        cars.get(0).position = 1;
        cars.get(1).position = 3;
        cars.get(2).position = 2;
        assertThat(Application.getWinPosition(cars)).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("getWinners 테스트")
    void getWinnersTest(List<RacingCar> cars) {
        cars.get(0).position = 1;
        cars.get(1).position = 3;
        cars.get(2).position = 2;
        List<String> winners = Application.getWinners(cars, 3);
        for (RacingCar car : cars) {
            if (car.position == 3) {//3은 maxPosition
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

    static Stream<Arguments> generateData() {
        List<RacingCar> cars1 = List.of(new RacingCar("car1"), new RacingCar("car2"), new RacingCar("car3"));
        List<RacingCar> cars2 = List.of(new RacingCar("carA"), new RacingCar("carB"), new RacingCar("carC"));
        return Stream.of(
                Arguments.of(cars1),
                Arguments.of(cars2)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
