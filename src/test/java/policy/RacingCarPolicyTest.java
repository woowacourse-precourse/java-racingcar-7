package policy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.policy.RacingCarPolicy;
import racingcar.domain.policy.RacingPolicy;

class RacingCarPolicyTest {

    @DisplayName("랜덤값으로 전진여부를 판별한다.")
    @Test
    void isMoveForward(){
    //given

    //when

    //then

    }
    @DisplayName("전진 기호를 가져온다.")
    @Test
    void getMoveForwardSymbol(){
        //given
        RacingPolicy racingCarPolicy = new RacingCarPolicy();

        //when
        String moveForwardSymbol = racingCarPolicy.getMoveForwardSymbol();

        //then
        Assertions.assertThat(moveForwardSymbol).isEqualTo("-");

    }
    @DisplayName("이름을 나누는 구분자를 가져온다.")
    @Test
    void getNameSeparator(){
        //given
        RacingPolicy racingCarPolicy = new RacingCarPolicy();

        //when
        String nameSeparator = racingCarPolicy.getNameSeparator();

        //then
        Assertions.assertThat(nameSeparator).isEqualTo(",");

    }
    @DisplayName("이름의 최대길이 기준을 가져온다.")
    @Test
    void getNameLengthPolicy(){
        //given
        RacingPolicy racingCarPolicy = new RacingCarPolicy();

        //when
        int nameLengthPolicy = racingCarPolicy.getNameLengthPolicy();

        //then
        Assertions.assertThat(nameLengthPolicy).isEqualTo(5);

    }

}