package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RacingcarTest {

    @Test
    void 이름이_공백일_때_테스트(){
        //given
        String name1 = "";
        String name2 = " ";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Racingcar(name1);
        });

        Throwable result2 = catchThrowable(() -> {
            new Racingcar(name2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5글자_초과일_때_테스트(){
        //given
        String name1 = "abcdef";
        String name2 = "abcdefghi";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Racingcar(name1);
        });

        Throwable result2 = catchThrowable(() -> {
            new Racingcar(name2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

}
