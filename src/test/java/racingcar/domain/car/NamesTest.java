package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    @DisplayName("이름 개수가 500개 초과 시 예외 발생")
    void createNamesWithExceedLimitThrowsException() {
        List<Name> names = new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            names.add(new Name(i + ""));
        }

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름 존재 시 예외 발생")
    void createNamesWithDuplicateNameThrowsException() {
        List<Name> names = new ArrayList<>();
        names.add(new Name("test1"));
        names.add(new Name("test2"));
        names.add(new Name("test1"));

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
