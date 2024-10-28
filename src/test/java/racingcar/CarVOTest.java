package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarVO;
import racingcar.vo.TestCarVO;

public class CarVOTest {

    @Test
    @DisplayName("CarVO 객체가 올바르게 생성되어야 한다")
    void 자동차_객체_생성_테스트() {
        // Given: 자동차 이름이 "pobi"인 자동차 객체 생성
        String carName = "pobi";

        // When: CarVO 객체를 생성
        CarVO carVO = new CarVO(carName);

        // Then: 생성된 자동차 이름과 초기 위치를 검증
        assertThat(carVO.getCarName()).isEqualTo("pobi");
        assertThat(carVO.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 결과가 바르게 출력되야 한다.")
    void 자동차_이동_출력_테스트() {
        // Given: 자동차 리스트와 이동 횟수 설정
        TestCarVO car1 = new TestCarVO("pobi");
        TestCarVO car2 = new TestCarVO("woni");
        TestCarVO car3 = new TestCarVO("jun");
        List<TestCarVO> testCarVOS = Arrays.asList(car1, car2, car3);

        // When: 1회 이동, 랜덤 값 4 이상일 경우 이동
        car1.move(4); // 이동
        car2.move(3); // 정지
        car3.move(5); // 이동

        // Then: 이동 후 각 자동차의 위치 확인
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
        assertThat(car3.getPosition()).isEqualTo(1);

        // Then: 상태 출력 확인
        assertThat(car1.getCurrentState()).isEqualTo("pobi : -");
        assertThat(car2.getCurrentState()).isEqualTo("woni : ");
        assertThat(car3.getCurrentState()).isEqualTo("jun : -");
    }
}
