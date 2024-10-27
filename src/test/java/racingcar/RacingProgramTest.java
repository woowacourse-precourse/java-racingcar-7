package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingProgramTest {

    private RacingProgram racingProgram;

    @BeforeEach
    void setUp(){
        // 테스트마다 새로운 인스턴스 생성
        racingProgram = new RacingProgram();
    }

    @Test
    void 올바른_입력_테스트(){
        String input = "test1,test2,test3";

        List<Car> cars = racingProgram.splitName(input);

        assertThat(cars).hasSize(3);
    }

    @Test
    void 공백_예외_테스트(){
        //문자열 내에 공백이 입력되는 경우
        String input = "test1,,test2";

        Assertions.assertThatThrownBy(() -> racingProgram.splitName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_예외_테스트(){
        //차량 이름이 중복되는 경우
        String input = "test1,test1,test2";

        Assertions.assertThatThrownBy(() -> racingProgram.splitName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 글자수_예외_테스트(){
        //차량 이름중에 5글자를 넘어가는 경우
        String input = "test1,test12,test2";

        Assertions.assertThatThrownBy(() -> racingProgram.splitName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_게임_횟수_테스트(){
        String input = "5";

        int attemptNumber = racingProgram.parseStringToNumber(input);

        assertThat(attemptNumber).isEqualTo(5);
    }

    @Test
    void 형식_예외_테스트(){
        String input = "wrong";

        assertThatThrownBy(() -> racingProgram.parseStringToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_게임_횟수_테스트(){
        String input = "-10";

        assertThatThrownBy(() -> racingProgram.parseStringToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수_0_입력_테스트(){
        String input = "0";

        assertThatThrownBy(() -> racingProgram.parseStringToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}