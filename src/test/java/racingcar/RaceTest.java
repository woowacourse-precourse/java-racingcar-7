package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    @DisplayName("자동차 추가 테스트 - Race에 자동차가 성공적으로 추가되는지 확인")
    void testAddCar() {
        // given
        Car car = new Car("car1");

        // when
        race.addCar(car);

        // then
        assertThat(race.getCarsStatus()).containsExactly(car); // 수정필요
    }

    @Test
    @DisplayName("이동횟수 설정테스트 - 이동 횟수가 잘 설정되었는지 확인")
    void testSetMoveCount() {
        // given
        int moveCount = 3;

        // when
        race.setMoveCount(moveCount);

        // then
        assertThat(race.getMoveCount()).isEqualTo(moveCount);
    }


    @Test
    @DisplayName("자동차 이동 테스트 - 각 턴마다 모든 자동차가 이동함")
    void testPlayTurn() {
        // given
        Car car1 = new Car("car1") {
            @Override
            protected int getRandomNumber() { return 9; } // 무조건 전진
        };
        Car car2 = new Car("car2") {
            @Override
            protected int getRandomNumber() { return 0; } // 무조건 정지
        };
        race.addCar(car1);
        race.addCar(car2);

        // when
        race.playTurn();

        // then
        assertThat(car1.getPosition()).isEqualTo(1); // 무조건 전진한 car1
        assertThat(car2.getPosition()).isEqualTo(0); // 무조건 멈춘 car2
    }

    @Test
    @DisplayName("우승자 결정 테스트 - 가장 멀리 있는 자동차가 우승자")
    void testGetWinners() {
        // given
        Car car1 = new Car("car1") {
            @Override
            protected int getRandomNumber() { return 9; }
        };
        Car car2 = new Car("car2") {
            @Override
            protected int getRandomNumber() { return 0; }
        };
        race.addCar(car1);
        race.addCar(car2);

        // when
        race.playTurn();

        // then
        List<String> winners = race.getWinners();
        assertThat(winners).containsExactly(car1.getName());
    }
}
