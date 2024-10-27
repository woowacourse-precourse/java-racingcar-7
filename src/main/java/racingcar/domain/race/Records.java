package racingcar.domain.race;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;

public class Records {
    private final Map<CarName, Distance> records;

    public Records() {
        records = new LinkedHashMap<>();
    }

    public void addRecord(CarName carName, Distance distance) {
        records.put(carName, distance);
    }

    public String generateRecordsMessage() {
        StringBuilder message = new StringBuilder();

        for (Entry<CarName, Distance> entry : records.entrySet()) {
            CarName carName = entry.getKey();
            Distance distance = entry.getValue();
            message.append(carName.getName()).append(" : ");
            message.append("-".repeat(distance.getDistance()));
            message.append(System.lineSeparator());
        }

        return message.toString();
    }
}
