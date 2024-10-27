package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.vehicle.car.Name;

public class NameTest {
    private Name name;

    @BeforeEach
    void setUp() {
        this.name = new Name("gamza");
    }

    @Test
    @DisplayName("이름 테스트")
    void getNameTest() {
        //given
        String expected = "gamza";
        //when
        String actual = name.getName();
        //then
        assertThat(expected).isEqualTo(actual);
    }
}
