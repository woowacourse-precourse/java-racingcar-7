package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameExtractorTest {

    @DisplayName("정상적인 문자열이 들어오면 반환되는 리스트에 이름이 존재해야 한다")
    @Test
    void containsName() {
        //given
        String userInput = "apple, banana, carrot, woowa, tech";

        //when
        List<String> names = NameExtractor.getNames(userInput);

        //then
        assertThat(names).contains("apple", "banana", "carrot", "woowa", "tech");
    }

    @DisplayName("정상적인 문자열이 들어어면 이름의 갯수와 리스트의 크기가 동일해야 한다")
    @Test
    void equalsSize() {
        //given
        String userInput = "apple, banana, carrot, woowa, tech";
        int size = 5;

        //when
        List<String> names = NameExtractor.getNames(userInput);

        //then
        assertThat(names.size()).isEqualTo(size);
    }
}