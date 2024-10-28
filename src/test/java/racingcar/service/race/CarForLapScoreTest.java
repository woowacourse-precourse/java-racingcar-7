package racingcar.service.race;

import racingcar.domain.Car;
import racingcar.domain.Engine;

public class CarForLapScoreTest implements Car {

    private final String name;
    private final Engine engine;
    private Long mileage;
    private Long oilGauge;

    public CarForLapScoreTest(String name, Engine engine, Long mileage, Long oilGauge) {
        this.name = name;
        this.engine = engine;
        this.mileage = mileage;
        this.oilGauge = oilGauge;
    }

    @Override
    public void accelerate() {
        if(enoughOil()){
            mileage += engine.getPerformance();
            oilGauge -= engine.getOilConsumption();
        }
    }

    private Boolean enoughOil() {
        return oilGauge >= engine.getOilConsumption();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getMileage() {
        return mileage;
    }

    @Override
    public Long oilStatus() {
        return oilGauge;
    }
}
