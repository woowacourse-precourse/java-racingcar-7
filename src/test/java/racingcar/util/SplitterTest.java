package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {
    @Test
    void 쉼표기준으로_문자열_분리_테스트() {
        // given
        String in = "ㅋㅋㅋㅋ,ㅋㅋㅋㅋ,ㅋㅋㅋㅋ";

        // when
        System.out.println("=====Logic Start=====");

        List<String> split = Splitter.split(in);

        System.out.println("=====Logic End=====");
        // then
        assertThat(split.size()).isEqualTo(3);

    }

}