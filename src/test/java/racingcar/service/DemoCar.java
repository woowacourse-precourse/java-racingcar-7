package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Engine;

public class DemoCar implements Car {

    private String name;
    private Engine engine;
    private Long mileage;
    private Long oilGauge;

    public DemoCar(String name, Engine engine, Long mileage, Long oilGauge) {
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

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long oilStatus() {
        return oilGauge;
    }

    public void setOilGauge(Long oilGauge) {
        this.oilGauge = oilGauge;
    }
}
