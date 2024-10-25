package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VehicleTest {

    @Test
    @DisplayName("자동차 이름 등록")
    void 자동차_이름_등록() {
        Vehicle vehicle = new Vehicle("pobi");
        assertThat(vehicle.getVehicleName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름 길이 0 등록 ")
    void 자동차_이름_길이_0_등록() {
        assertThatThrownBy(() -> new Vehicle(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 null 등록 ")
    void 자동차_이름_null_등록() {
        assertThatThrownBy(() -> new Vehicle(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 공백 등록 ")
    void 자동차_이름_공백_등록() {
        assertThatThrownBy(() -> new Vehicle(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("포함 자동차 이름(사이 공백 포함) 5자 초과 등록 ")
    void 자동차_이름_사이_공백_5자_초과_등록() {
        assertThatThrownBy(() -> new Vehicle("12 456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}