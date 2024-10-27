package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_DUPLICATE;

class VehiclesTest {
    Vehicles vehicles;

    @BeforeEach
    void asd() {
        vehicles = new Vehicles("pobi,woni,jun,min,gwan");
    }

    @Test
    @DisplayName("자동차 이름 정상 등록")
    void 자동차_이름_정상_등록() {
        //given
        //when
        //then
        assertThat(vehicles.getVehicles())
                .extracting(Vehicle::getVehicleName)
                .containsExactly("pobi", "woni", "jun", "min", "gwan");
    }

    @Test
    @DisplayName("자동차 공백 포함 이름 정상 등록")
    void 자동차_공백_포함_이름_정상_등록() {
        //given
        Vehicles vehicles = new Vehicles("pobi,woni,jun,kim m,lee j");

        //when
        //then
        assertThat(vehicles.getVehicles())
                .extracting(Vehicle::getVehicleName)
                .containsExactly("pobi", "woni", "jun", "kim m", "lee j");
    }

    @Test
    @DisplayName("자동차 이름 중복시 예외 발생")
    void 자동차_이름_중복시_예외_발생() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Vehicles("pobi,woni,jun,min,min"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VEHICLE_NAME_CANNOT_BE_DUPLICATE);
    }

    @Test
    @DisplayName("우승자 1명 출력")
    void 우승자_1명_출력() {
        //given
        Vehicle pobi = vehicles.getVehicles().getFirst();
        pobi.moveOrStay(4);

        //when
        String raceWinner = vehicles.getRaceWinner();

        //then
        assertThat(raceWinner).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자 N명 출력")
    void 우승자_N명_출력() {
        //given
        Vehicle pobi = vehicles.getVehicles().getFirst();
        pobi.moveOrStay(4);

        Vehicle jun = vehicles.getVehicles().get(2);
        jun.moveOrStay(9);

        Vehicle gwan = vehicles.getVehicles().getLast();
        gwan.moveOrStay(5);

        //when
        String raceWinner = vehicles.getRaceWinner();

        //then
        assertThat(raceWinner).isEqualTo("pobi, jun, gwan");
    }
}