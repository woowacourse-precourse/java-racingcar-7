package racingcar.properties;

import racingcar.properties.function.CarMoveNumberPicker;
import racingcar.properties.function.CarNameFilter;
import racingcar.properties.function.CarPositionPrinter;

public class RacingProperties {

    private final CarNameFilter carNameFilter;
    private final CarPositionPrinter carPositionPrinter;
    private final CarMoveNumberPicker carMoveNumberPicker;

    private RacingProperties(RacingPropertiesBuilder builder) {
        this.carNameFilter = builder.carNameFilter;
        this.carPositionPrinter = builder.carPositionPrinter;
        this.carMoveNumberPicker = builder.carMoveNumberPicker;
    }

    public static RacingPropertiesBuilder builder() {
        return new RacingPropertiesBuilder();
    }

    public CarNameFilter getCarNameFilter() {
        return carNameFilter;
    }

    public CarPositionPrinter getCarPositionPrinter() {
        return carPositionPrinter;
    }

    public CarMoveNumberPicker getCarMoveNumberPicker() {
        return carMoveNumberPicker;
    }

    public static class RacingPropertiesBuilder {

        private CarNameFilter carNameFilter;
        private CarPositionPrinter carPositionPrinter;
        private CarMoveNumberPicker carMoveNumberPicker;

        public RacingPropertiesBuilder carNameFilter(CarNameFilter carNameFilter) {
            this.carNameFilter = carNameFilter;
            return this;
        }

        public RacingPropertiesBuilder carPositionPrinter(CarPositionPrinter carPositionPrinter) {
            this.carPositionPrinter = carPositionPrinter;
            return this;
        }

        public RacingPropertiesBuilder carMoveNumberPicker(CarMoveNumberPicker carMoveNumberPicker) {
            this.carMoveNumberPicker = carMoveNumberPicker;
            return this;
        }

        public RacingProperties build() {
            return new RacingProperties(this);
        }
    }
}
