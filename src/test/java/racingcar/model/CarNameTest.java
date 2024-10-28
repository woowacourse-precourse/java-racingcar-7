package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("유효한 이름으로 객체를 생성할 수 있다")
    void 유효한_이름_객체_생성() {
        String validName = "A".repeat(CarName.MAX_NAME_LENGTH);
        CarName carName = new CarName(validName);
        assertThat(carName.getName()).isEqualTo(validName);
    }

    @Test
    @DisplayName("이름이 유효하지 않으면 예외를 발생시킨다")
    void 유효하지_않은_이름_예외_발생() {
        String tooLongName = "A".repeat(CarName.MAX_NAME_LENGTH + 1);
        assertThrows(IllegalArgumentException.class, () -> {
            new CarName(tooLongName);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CarName("av.ad");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CarName("as as");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CarName("    ");
        });
    }
}