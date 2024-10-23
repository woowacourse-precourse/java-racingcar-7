package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacePreparationTest {
    private RacePreparation racePreparation;

    @BeforeEach
    void setUp() {
        racePreparation = new RacePreparation("test1, test2", "5");
    }

    @Test
    void nothing() {
        System.out.println("nothing");
    }

    @Test
    void 자동차_이름_입력_테스트() {
        assertEquals(List.of("test1", "test2"), racePreparation.getCarNames());
    }

    @Test
    void 자동차_이름_입력_중복_케이스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacePreparation("test1,test1", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_입력_공백_케이스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacePreparation("test1,,test2", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_횟수_입력_케이스_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacePreparation("test1,test2", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}