package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private Long performanceRegulation;
    private Long oilConsumption;
    private Long oilRegulation;

    private RacingCar createCar (String carName) {
        return new RacingCar(carName,oilRegulation,createEngine());
    }

    private Engine createEngine() {
        performanceRegulation = 1L;
        oilConsumption = 1L;
        return new Engine(performanceRegulation,oilConsumption);
    }

    @Test
    @DisplayName("자동차 생성 시 이름 지정 테스트")
    void carNameSetting() {
        String carName = "Test Car";
        assertEquals(carName,createCar(carName).getName());
    }

    @Test
    @DisplayName("자동차 생성 시 달린 거리 0 테스트")
    void carBasicMileageSetting() {
        Long newCarMileage = 0L;
        assertEquals(newCarMileage, createCar("Test Car").getMileage());
    }

    @Test
    @DisplayName("자동차 생성 시 기름 주입 테스트")
    void injectOilFromCarSetting() {
        oilRegulation = 1L;
        assertEquals(oilRegulation, createCar("Test Car").oilStatus());
    }

    @Test
    @DisplayName("자동차 생성 시 엔진 테스트")
    void engineSetting() {
        RacingCar testCar = createCar("Test Car");

        assertEquals(performanceRegulation, testCar.getEngine().getPerformance());
        assertEquals(oilConsumption, testCar.getEngine().getOilConsumption());
    }

    @Test
    @DisplayName("자동차 주행 테스트(이동)")
    void acceleratorTest_mileage() {
        oilRegulation = 1L;
        Car testCar = createCar("Test Car");

        testCar.accelerate();

        Long expected_mileage = performanceRegulation;

        assertEquals(expected_mileage, testCar.getMileage());
    }

    @Test
    @DisplayName("자동차 주행 테스트(기름 소모)")
    void acceleratorTest_oilConsumption() {
        oilRegulation = 2L;

        Long injectedOil = oilRegulation;
        RacingCar testCar = createCar("Test Car");

        testCar.accelerate();
        Long expected = injectedOil - oilConsumption;

        assertEquals(expected, testCar.oilStatus());
    }
}