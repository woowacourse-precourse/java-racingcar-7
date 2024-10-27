package racingcar.util;

import racingcar.model.Vehicle;

import java.util.List;

public class WinnerAggregater {

    public static <T extends Vehicle> String getWinner(List<T> vehicles) {
        int maxPosition = 0;
        for (Vehicle vehicle : vehicles) {
            maxPosition = Math.max(maxPosition, vehicle.getPosition());
        }
        return getWinnerName(vehicles, maxPosition);
    }

    private static <T extends Vehicle> String getWinnerName(List<T> vehicles, int maxPosition) {
        StringBuilder winnerName = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPosition() == maxPosition) {
                winnerName.append(vehicle.getName()).append(", ");
            }
        }
        return winnerName.deleteCharAt(winnerName.length() - 2).toString();
    }
}
