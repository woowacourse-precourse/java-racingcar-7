package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_DUPLICATE;
import static racingcar.constant.Race.*;

public class Vehicles {
    private final List<Vehicle> vehicles;

    public Vehicles(String inputVehicles) {
        List<String> vehicles = Arrays.stream(inputVehicles.split(COMMA))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();

        Set<String> uniqueNames = Set.copyOf(vehicles);
        if (uniqueNames.size() < vehicles.size()) {
            throw new IllegalArgumentException(VEHICLE_NAME_CANNOT_BE_DUPLICATE);
        }

        this.vehicles = vehicles.stream()
                .map(Vehicle::new)
                .toList();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void processRound() {
        vehicles.forEach(vehicle -> vehicle.moveOrStay(Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER)));
    }

    public void raceResult() {
        vehicles.forEach(vehicle -> System.out.println(vehicle.getCurrentDistanceToSymbol()));
        System.out.println();
    }

    public String getRaceWinner() {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getCurrentDistance() == Vehicle.MAX_RACE_DISTANCE)
                .map(Vehicle::getVehicleName)
                .collect(Collectors.joining(WINNER_DELIMITER_COMMA));
    }

    public void raceStart(int raceRounds) {
        for (int i = 0; i < raceRounds; i++) {
            processRound();

            if (i == 0) System.out.println("결과 출력");
            raceResult();
        }
        System.out.println("최종 우승자 : " + getRaceWinner());
    }
}
