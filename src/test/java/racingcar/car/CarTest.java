package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.observer.CarObserver;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static final String CAR_NAME = "jjj";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    @DisplayName("Car 객체 생성 시, 초기 위치는 0이어야 한다.")
    void createCar_initialPositionIsZero() {
        // then
        assertEquals(0, car.getPosition(), "초기 위치는 0이어야 합니다.");
    }

    @Test
    @DisplayName("Car 객체 생성 시, 이름이 올바르게 설정되어야 한다.")
    void createCar_nameIsSetCorrectly() {
        // then
        assertEquals(CAR_NAME, car.getName(), "이름이 올바르게 설정되어야 합니다.");
    }

    @Test
    @DisplayName("randomValue가 4 이상일 때, 자동차가 전진해야 한다.")
    void move_whenRandomValueIsGreaterThanOrEqualToFour_carMovesForward() {
        // when
        car.move(4);

        // then
        assertEquals(1, car.getPosition(), "randomValue가 4 이상일 때, 자동차가 전진해야 합니다.");
    }

    @Test
    @DisplayName("randomValue가 4 미만일 때, 자동차가 정지해야 한다.")
    void move_whenRandomValueIsLessThanFour_carDoesNotMove() {
        // when
        car.move(3);

        // then
        assertEquals(0, car.getPosition(), "randomValue가 4 미만일 때, 자동차가 정지해야 합니다.");
    }

    @Test
    @DisplayName("옵저버를 추가하면 옵저버 목록에 포함되어야 한다.")
    void addObserver_observerIsAddedToObserversList() {
        // given
        TestCarObserver observer = new TestCarObserver();

        // when
        car.addObserver(observer);
        car.move(4);

        // then
        assertTrue(observer.isNotified(), "옵저버는 알림을 받아야 합니다.");
    }

    @Test
    @DisplayName("옵저버를 제거하면 옵저버 목록에서 제외되어야 한다.")
    void removeObserver_observerIsRemovedFromObserversList() {
        // given
        TestCarObserver observer = new TestCarObserver();
        car.addObserver(observer);
        car.removeObserver(observer);

        // when
        car.move(4);

        // then
        assertFalse(observer.isNotified(), "옵저버는 알림을 받지 않아야 합니다.");
    }

    // 테스트용 옵저버 클래스
    private static class TestCarObserver implements CarObserver {
        private boolean notified = false;

        @Override
        public void onMoved(Car car) {
            this.notified = true;
        }

        public boolean isNotified() {
            return notified;
        }
    }

}