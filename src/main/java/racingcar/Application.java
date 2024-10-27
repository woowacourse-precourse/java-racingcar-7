package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Vehicle;
import racingcar.model.Vehicles;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static racingcar.constant.ErrorMessage.RACE_ROUND_ONLY_CAN_NUMBER;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_DUPLICATE;
import static racingcar.constant.Race.COMMA;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputVehicles = Console.readLine();

        List<Vehicle> uniqueVehicles = createUniqueVehicles(inputVehicles);
        Vehicles vehicles = new Vehicles(uniqueVehicles);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceRoundsInput = Console.readLine();

        int raceRounds = parseRaceRounds(raceRoundsInput);
        vehicles.raceStart(raceRounds);
    }

    private static int parseRaceRounds(String raceRoundsInput) {
        try {
            return Integer.parseInt(raceRoundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_ROUND_ONLY_CAN_NUMBER);
        }
    }

    private static List<Vehicle> createUniqueVehicles(String inputVehicles) {
        List<String> vehicles = Arrays.stream(inputVehicles.split(COMMA))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();

        Set<String> uniqueNames = Set.copyOf(vehicles);
        if (uniqueNames.size() < vehicles.size()) {
            throw new IllegalArgumentException(VEHICLE_NAME_CANNOT_BE_DUPLICATE);
        }

        return vehicles.stream()
                .map(Vehicle::new)
                .toList();
    }
}