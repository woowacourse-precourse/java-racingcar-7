package racingcar.separator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ExtractorTest {
    @Test
    void 추출_테스트(){
        List<String> names = Extractor.extract("pobi,woni,jun");

        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 공백_테스트(){
        List<String> names = Extractor.extract(",   ,");

        assertThat(names).containsExactly("", "", "");
    }
}
