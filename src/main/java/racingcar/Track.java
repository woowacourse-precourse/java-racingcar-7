package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class Track {

    private final Map<Vehicle, Integer> vehiclePositionMap = new HashMap<>();

    public Track(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehiclePositionMap.put(vehicle, 0);
        }
    }

    public void runOneCycle() {
        for (Entry<Vehicle, Integer> vehicleIntegerEntry : vehiclePositionMap.entrySet()) {
            Vehicle vehicle = vehicleIntegerEntry.getKey();
            Integer position = vehicleIntegerEntry.getValue();
            runVehicle(vehicle);
        }
    }

    public String selectWinner() {
        int maxPosition = getMaxPosition();
        StringJoiner winnerStringJoiner = new StringJoiner(",");

        vehiclePositionMap.entrySet().stream()
                .filter(entry -> entryHasMaxPosition(entry, maxPosition))
                .map(Entry::getKey)
                .forEach(vehicle -> winnerStringJoiner.add(vehicle.getName()));

        return winnerStringJoiner.toString();
    }

    private boolean entryHasMaxPosition(Entry<Vehicle, Integer> entry, Integer maxPosition) {
        return entry.getValue().equals(maxPosition);
    }

    private int getMaxPosition() {
        return vehiclePositionMap.values().stream()
                .mapToInt(x -> x)
                .max()
                .orElseThrow(() -> new RuntimeException("경주중인 대상이 없습니다"));
    }

    public void runVehicle(Vehicle vehicle) {
        Integer currentPosition = vehiclePositionMap.get(vehicle);
        vehiclePositionMap.put(vehicle, currentPosition);
    }
}
