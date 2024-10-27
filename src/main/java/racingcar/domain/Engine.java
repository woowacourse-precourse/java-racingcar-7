package racingcar.domain;

public class Engine {

    private final Long performance;
    private final Long oilConsumption;

    public Engine(Long performanceRegulation, Long oilConsumption) {
        this.performance = performanceRegulation;
        this.oilConsumption = oilConsumption;
    }

    public Long getPerformance() {
        return performance;
    }

    public Long getOilConsumption() {
        return oilConsumption;
    }
}
