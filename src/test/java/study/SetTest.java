package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void Set의_크기를_확인() {
        // given
        int expectedSize = 3;

        // when
        int actualSize = numbers.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Set에_값이_존재하는지_확인(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void Set_값이_존재하는지_여부를_확인(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
