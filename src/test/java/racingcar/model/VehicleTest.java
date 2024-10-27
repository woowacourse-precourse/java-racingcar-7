package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_EMPTY;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_MORE_FIVE;

class VehicleTest {
    static final char MOVE_SYMBOL = '-';
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
                .hasMessage(VEHICLE_NAME_CANNOT_BE_EMPTY);
    }

    @Test
    @DisplayName("자동차 이름 null 등록 ")
    void 자동차_이름_null_등록() {
        assertThatThrownBy(() -> new Vehicle(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VEHICLE_NAME_CANNOT_BE_EMPTY);
    }

    @Test
    @DisplayName("자동차 이름 공백 등록 ")
    void 자동차_이름_공백_등록() {
        assertThatThrownBy(() -> new Vehicle(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VEHICLE_NAME_CANNOT_BE_EMPTY);
    }

    @Test
    @DisplayName("포함 자동차 이름(사이 공백 포함) 5자 초과 등록 ")
    void 자동차_이름_사이_공백_5자_초과_등록() {
        assertThatThrownBy(() -> new Vehicle("12 456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VEHICLE_NAME_CANNOT_BE_MORE_FIVE);
    }

    @Test
    @DisplayName("무작위 값 4 미만이면 정지")
    void 무작위_값_4_미만이면_정지(){
        //given
        Vehicle vehicle = new Vehicle("pobi");
        int distance = vehicle.getCurrentDistance();

        //when
        vehicle.moveOrStay(3);

        //then
        assertThat(vehicle.getCurrentDistance()).isEqualTo(distance);
    }

    @Test
    @DisplayName("무작위 값 4 미만이면 심볼 수 유지")
    void 무작위_값_4_미만이면_심볼_수_유지(){
        //given
        Vehicle vehicle = new Vehicle("pobi");
        long distanceToSymbolCount = vehicle.getCurrentDistanceToSymbol().chars()
                .filter(ch -> ch == MOVE_SYMBOL)
                .count();

        //when
        vehicle.moveOrStay(1);
        vehicle.moveOrStay(2);
        vehicle.moveOrStay(3);
        long currentDistanceToSymbolCount = vehicle.getCurrentDistanceToSymbol().chars()
                .filter(ch -> ch == MOVE_SYMBOL)
                .count();

        //then
        assertThat(currentDistanceToSymbolCount).isEqualTo(distanceToSymbolCount);
    }

    @Test
    @DisplayName("무작위 값 4 이상이면 전진")
    void 무작위_값_4_이상이면_전진(){
        //given
        Vehicle vehicle = new Vehicle("pobi");
        int distance = vehicle.getCurrentDistance();
        //when
        vehicle.moveOrStay(4);
        //then
        assertThat(vehicle.getCurrentDistance()).isEqualTo(distance + 1);
    }

    @Test
    @DisplayName("무작위 값 4 이상이면 심볼 수 증가")
    void 무작위_값_4_이상이면_심볼_수_증가(){
        //given
        Vehicle vehicle = new Vehicle("pobi");
        long distanceToSymbolCount = vehicle.getCurrentDistanceToSymbol().chars()
                .filter(ch -> ch == MOVE_SYMBOL)
                .count();

        //when
        vehicle.moveOrStay(4);
        vehicle.moveOrStay(5);
        vehicle.moveOrStay(6);
        long currentDistanceToSymbolCount = vehicle.getCurrentDistanceToSymbol().chars()
                .filter(ch -> ch == MOVE_SYMBOL)
                .count();

        //then
        assertThat(currentDistanceToSymbolCount).isEqualTo(distanceToSymbolCount + 3);
    }
}