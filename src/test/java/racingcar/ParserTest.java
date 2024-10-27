package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    void 쉼표를_기준으로_자르고_리스트를_반환합니다() {
        // when
        List<String> result = Parser.splitByDelimiter("1,2,3");

        // then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void Integer로_반환하고_숫자로_변환합니다() {
        // when
        Integer result = Parser.toInteger("2345");

        // then
        assertThat(result).isInstanceOf(Integer.class);
        assertThat(result).isEqualTo(2345);
    }
}