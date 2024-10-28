package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @DisplayName("자동차 이름 목록을 통해 자동차 객체 목록을 생성하고 반환한다.")
    @ParameterizedTest(name = "이름 목록 : {0}, 자동차 목록 : {1}")
    @MethodSource("provideCarNames")
    void createCars(List<String> nameList, List<String> expectedNames) {
        // when
        List<Car> carList = Cars.createCars(nameList);

        // then
        Assertions.assertThat(carList)
                .hasSize(expectedNames.size())  // 자동차 목록의 크기가 주어진 크기와 일치하는지 확인
                .extracting(Car::getName)  // 각 Car 객체의 이름을 추출
                .containsExactlyElementsOf(expectedNames);  // 이름이 예상 결과와 동일한지 확인
    }

    @DisplayName("위치의 최대값이 주어졌을 때 올바른 승리 그룹을 찾을 수 있다.")
    @ParameterizedTest(name = "maxPosition: {0}, given: {1}, expectedWinners: {2}")
    @MethodSource("provideCarList")
    void findWinner(int maxPosition, List<Car> givenCars, int expectedWinnerCount) {
        // given
        Cars cars = new Cars(givenCars);

        // when
        List<Car> winner = cars.findWinner();

        // then
        assertThat(winner).hasSize(expectedWinnerCount);
        assertThat(winner).map(Car::getPosition).contains(maxPosition);
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(List.of("재석", "하하", "광수"), List.of("재석", "하하", "광수")),
                Arguments.of(List.of("1", "2"), List.of("1", "2")),
                Arguments.of(List.of("솔로"), List.of("솔로"))
        );
    }

    private static Stream<Arguments> provideCarList() {
        return Stream.of(
                Arguments.of(
                        5,
                        List.of(
                                new Car("a", 5),
                                new Car("b", 5),
                                new Car("c", 5)), 3),
                Arguments.of(
                        5,
                        List.of(
                                new Car("a", 5),
                                new Car("b", 5),
                                new Car("c", 3)), 2),
                Arguments.of(
                        10,
                        List.of(
                                new Car("a", 10),
                                new Car("b", 5),
                                new Car("c", 3)), 1)
        );
    }
}