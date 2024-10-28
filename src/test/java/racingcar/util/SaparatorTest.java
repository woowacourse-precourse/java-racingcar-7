package racingcar.util;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaparatorTest {

    @Test
    void split(){
        Saparator saparator = new Saparator(",");
        String s = "abc,test,time";
        String[] result = saparator.split(s);
        assertThat(result[0]).isEqualTo("abc");
        assertThat(result[1]).isEqualTo("test");
        assertThat(result[2]).isEqualTo("time");

        s = "";

    }

    @Test
    void splitException(){
        Saparator saparator = new Saparator(",");
        assertThrows(IllegalArgumentException.class, ()->saparator.split(""));
        assertThrows(IllegalArgumentException.class, ()->saparator.split(null));
    }
}