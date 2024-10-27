package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.member.Member;

class CarTest {

    @Test
    @DisplayName("Car객체를 생성하면 racingDistance가 0으로 초기설정된다.")
    void car_객체_생성_테스트() {
        Member member = new Member("member");
        Car car = Car.of(member);
        Assertions.assertThat(car.getRacingDistance()).isZero();
    }
}