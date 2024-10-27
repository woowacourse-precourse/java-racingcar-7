package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Race.*;

public class Vehicles {
    private final List<Vehicle> vehicles;

    public Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void processRound() {
        vehicles.forEach(vehicle -> vehicle.moveOrStay(Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER)));
    }

    public void raceResult() {
        vehicles.forEach(vehicle -> System.out.println(vehicle.getCurrentDistanceToSymbol()));
        System.out.println();
    }

    public void raceWinner() {
        String result = vehicles.stream()
                .filter(vehicle -> vehicle.getCurrentDistance() == Vehicle.MAX_RACE_DISTANCE)
                .map(Vehicle::getVehicleName)
                .collect(Collectors.joining(WINNER_DELIMITER_COMMA));
        System.out.println("최종 우승자 : " + result);
    }

    public void raceStart(int raceRounds) {
        for (int i = 0; i < raceRounds; i++) {
            processRound();

            if (i == 0) System.out.println("결과 출력");
            raceResult();
        }
        raceWinner();
    }
}
