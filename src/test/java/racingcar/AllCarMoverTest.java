package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AllCarMoverTest {

    AllCarMover allCarMover = new AllCarMover();
    List<Car> cars = List.of(
            new Car("a"),
            new Car("b")
    );

    /*
     * Todo: CarMover, RandomNumberGenerator를 Mocking 하여 테스트 코드 작성하기
     *
     * 현재는 Mocking 불가능 한 상태
     * 우선 요구사항 구현에 집중하자
     */
    @Test
    @DisplayName("모든 차 한번 이동 수행 시도 성공 테스트")
    void run_테스트() {
        // when
        allCarMover.run(cars);
    }

}