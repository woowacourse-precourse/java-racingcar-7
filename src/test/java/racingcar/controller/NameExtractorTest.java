package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameExtractorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Car1,Car2","Car1,Car3"})
    void 이름구분_테스트(String str){
        assertThat(NameExtractor.extractNames(str)).isEqualTo(List.of(str.split(",")));
    }

}