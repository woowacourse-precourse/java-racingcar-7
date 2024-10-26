package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Racingcars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RacingcarsTest {

    @Test
    void 이름이_중복될_때_테스트(){
        //given
        List<String> names = List.of("name1", "name1", "name2");

        //when
        Throwable result = catchThrowable(() -> {
            new Racingcars(names);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
