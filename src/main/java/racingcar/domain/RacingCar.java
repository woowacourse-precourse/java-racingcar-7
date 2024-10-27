package racingcar.domain;

public class RacingCar implements Car{

    private final String name;
    private final Engine engine;

    private Long mileage;
    private Long oilGauge;

    public RacingCar(String name, Long oil, Engine engine) {
        this.name = name;
        this.oilGauge = oil;
        this.engine = engine;

        this.mileage = 0L;
    }


}
