package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarVOTest {

    @Test
    void 자동차_객체_생성_테스트() {
        // Given: 자동차 이름이 "pobi"인 자동차 객체 생성
        String carName = "pobi";

        // When: CarVO 객체를 생성
        CarVO carVO = new CarVO(carName);

        // Then: 생성된 자동차 이름과 초기 위치를 검증
        assertThat(carVO.getCarName()).isEqualTo("pobi");
        assertThat(carVO.getPosition()).isEqualTo(0);
    }
}
