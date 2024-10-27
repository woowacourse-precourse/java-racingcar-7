package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    public void 자동차_이름세팅_테스트() {
        List<String> validInput = List.of("pobi", "woni", "jun");
        racingCar.setCarList(validInput);

        assertEquals(3, racingCar.getCarList().size(), "3가지의 자동차가 생성되어야 한다.");
        assertEquals("pobi", racingCar.getCarList().get(0).getName());
        assertEquals("woni", racingCar.getCarList().get(1).getName());
        assertEquals("jun", racingCar.getCarList().get(2).getName());
    }

    @Test
    public void 자동차_이름세팅_예외_테스트(){
        List<String> invalidInput = List.of("pobi", "woniwonni", "jun");
        assertThatThrownBy(() -> racingCar.setCarList(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}