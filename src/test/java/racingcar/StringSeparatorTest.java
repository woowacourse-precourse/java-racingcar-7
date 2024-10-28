package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringSeparatorTest {


    @ParameterizedTest
    @CsvSource(value = {"one:,:one", "two:,:two"}, delimiter = ':')
    public void separateString(String baseString, String delimiter, String expected)
            throws Exception {
        //given
        StringSeparator stringSeparator = new StringSeparator(baseString, delimiter);

        //when
        String result = stringSeparator.next();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"one,two:,:one", "two,three:,:two"}, delimiter = ':')
    public void separateStringsAssertFirst(String baseString, String delimiter, String expected)
            throws Exception {
        //given
        StringSeparator stringSeparator = new StringSeparator(baseString, delimiter);

        //when
        String result = stringSeparator.next();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"one,two:,:two", "two,three:,:three"}, delimiter = ':')
    public void separateStringsAssertSecond(String baseString, String delimiter, String expected)
            throws Exception {
        //given
        StringSeparator stringSeparator = new StringSeparator(baseString, delimiter);

        //when
        stringSeparator.next();
        String result = stringSeparator.next();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void createStringSeparateWithNullAndEmptyBaseString(String baseString) throws Exception {
        //given
        String delimiter = ",";

        //when, then
        assertThatThrownBy(() -> {
            new StringSeparator(baseString, delimiter);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void createStringSeparateWithNullAndEmptyDelimiter(String delimiter) throws Exception {
        //given
        String baseString = "one,two";

        //when, then
        assertThatThrownBy(() -> {
            new StringSeparator(baseString, delimiter);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"one,two:,", "two,three:,"}, delimiter = ':')
    public void separateStringsWithNoNext(String baseString, String delimiter) throws Exception {
        //given
        StringSeparator stringSeparator = new StringSeparator(baseString, delimiter);

        //when
        stringSeparator.next();
        stringSeparator.next();
        assertThatThrownBy(() -> {
            stringSeparator.next();
        }).isInstanceOf(NoSuchElementException.class);
    }
}