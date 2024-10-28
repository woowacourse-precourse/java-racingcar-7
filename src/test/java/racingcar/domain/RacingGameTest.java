package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private List<Car> cars;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        racingGame = new RacingGame(cars, 5);
    }

    @Test
    @DisplayName("자동차의 초기 위치가 0으로 설정되는지 테스트")
    void carsStartAtPositionZero() {
        for (Car car : cars) {
            Assertions.assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("게임 시작 시 지정된 횟수만큼 라운드가 진행되는지 테스트")
    void start_runsForSpecifiedNumberOfRounds() {
        int[] initialPositions = cars.stream().mapToInt(Car::getPosition).toArray();

        // when
        racingGame.start();

        // then
        for (int i = 0; i < cars.size(); i++) {
            int positionDifference = cars.get(i).getPosition() - initialPositions[i];
            Assertions.assertThat(positionDifference).isBetween(0, 5);
        }
    }

    @Test
    @DisplayName("경주 게임을 시작할 때 자동차의 위치가 변경되는지 테스트")
    void start_updateCarPositions() {
        //when
        racingGame.start();

        //then
        for (Car car : racingGame.getCars()) {
            Assertions.assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName("자동차의 이동 범위가 설정한 조건에 맞게 제한되는지 테스트")
    void carMovement_withInDefinedRange() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        for (Car car : cars) {
            int initialPosition = car.getPosition();
            car.move(randomValue);
            if (randomValue >= 4) {
                Assertions.assertThat(car.getPosition()).isGreaterThan(initialPosition);
            } else {
                Assertions.assertThat(car.getPosition()).isEqualTo(initialPosition);
            }
        }
    }

    @Test
    @DisplayName("우승자 결정 시 가장 많이 이동한 자동차를 올바르게 선택하는지 테스트")
    void getWinners_returnsCorrectWinners() {
        //given
        cars.get(0).move(4);
        cars.get(1).move(3);
        cars.get(2).move(3);

        //when
        List<Car> winners = racingGame.getWinners();

        //then
        Assertions.assertThat(winners).containsExactly(cars.get(0));
    }

    @Test
    @DisplayName("우승자 결정 시 동일한 최종 위치를 가진 자동차들을 공동 우승자로 올바르게 선택하는지 테스트")
    void getWinners_returnsCorrectWinnersForTie() {
        //given
        for (int i = 0; i < 4; i++) {
            cars.get(0).move(4);
            cars.get(1).move(4);
        }
        for (int i = 0; i < 3; i++) {
            cars.get(2).move(4);
        }

        //when
        List<Car> winners = racingGame.getWinners();

        //then
        Assertions.assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }
}
