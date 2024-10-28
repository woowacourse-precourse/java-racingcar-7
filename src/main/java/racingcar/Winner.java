package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vehicle.Car;
import racingcar.vehicle.Vehicle;

public class Winner {

    static List<Vehicle> winners = new ArrayList<>();

    public List<Vehicle> getWinners() {
        return winners;
    }

    public void determine(List<Vehicle> vehicles) {
        int topForwardCount = vehicles.stream()
                .mapToInt(vehicle -> vehicle.getForwardCount())
                .max()
                .orElse(0);

        winners = vehicles.stream()
                .filter(vehicle -> vehicle.getForwardCount() == topForwardCount)
                .collect(Collectors.toList());
    }

}
