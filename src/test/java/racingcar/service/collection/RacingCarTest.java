package racingcar.service.collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * 입력 받은 레이싱 카 이름을 쉼표 기준으로 분리하는 기능 테스트 코드 작성
 * 앞으로 한 칸 전진하는 기능 테스트 코드 작성
 * 자동차 이름이 6글자 이상인 경우 예외 처리 테스트 코드 작성
 */
class RacingCarTest {

    @Test
    void 쉼표로_분리() {
        RacingCar racingCar = new RacingCar("a,b,c");

        Assertions.assertThat(racingCar.getAllRacingCarName())
                .containsExactly("a", "b", "c");
    }

    /*
     * 랜덤 값이 4 이상인 경우 앞으로 한 칸 전진하는 메서드는
     * Game 클래스의 start 메서드에 정의되어 있다.
     * 하지만 start 메서드는 0~9 사이 랜덤 값을 추출하여
     * 랜덤 값이 4 이상일 경우에만 앞으로 한 칸 전진하기 때문에
     * 랜덤 값이 4 이상이라는 가정 하에 앞으로 전진하는 RacingCar의 moveForward 메서드만 테스트를 진행하였다.
     */
    @Test
    @DisplayName("랜덤 값이 4 이상인 경우 앞으로 한 칸 전진한다.")
    void 한칸_전진() {
        RacingCar racingCar = new RacingCar("a");
        racingCar.moveForward("a");

        Assertions.assertThat(racingCar.getRacingCarPosition("a"))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 6글자 이상인 경우 예외 처리한다.")
    void 자동차_이름_6자_이상() {
        Assertions.assertThatThrownBy(() -> new RacingCar("a,abcdef,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}