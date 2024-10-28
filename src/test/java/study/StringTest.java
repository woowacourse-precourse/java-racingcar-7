package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    String emptyString = "";
    String whiteSpaceString = " ";
    String nullString = null;
    String delim = ",";

    @Test
    void isBlankTest() {
        // when & then
        assertThat(emptyString.isBlank()).isTrue();
        assertThat(whiteSpaceString.isBlank()).isTrue();
        assertThatThrownBy(() -> nullString.isBlank())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void isEmptyTest() {
        // when & then
        assertThat(emptyString.isEmpty()).isTrue();
        assertThat(whiteSpaceString.isEmpty()).isFalse();
        assertThatThrownBy(() -> nullString.isBlank())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void splitTest() {
        // given
        String a = "";
        String b = ",";
        String c = "a,";
        String d = ",a";
        String e = "a,,a";

        // when
        debug(a);
        debug(b);
        debug(c);
        debug(d);
        debug(e);
    }

    private void debug(String input) {
        print(input.split(delim));
        print(input.split(delim, -1));
        System.out.println();
    }

    private void print(String[] split) {
        System.out.println("split.length = " + split.length);
        for (String s : split) {
            System.out.println("s = " + s);
        }
    }

}
