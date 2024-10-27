package racingcar.util.formatter;

import java.util.List;
import racingcar.domain.Car;

public class PrintFormatter {
    public String formatRoundResult(Car car){
        return car.getName() + ": " + car.getCurrentDistance();
    }
}
