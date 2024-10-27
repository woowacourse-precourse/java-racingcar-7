package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constant.ErrorMessage.RACE_ROUND_ONLY_CAN_NUMBER;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_DUPLICATE;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputVehicles = Console.readLine();

        List<Vehicle> vehicles = createUniqueVehicles(inputVehicles);

        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            int raceRounds = Integer.parseInt(Console.readLine());
            raceStart(vehicles, raceRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_ROUND_ONLY_CAN_NUMBER);
        }
    }

    private static List<Vehicle> createUniqueVehicles(String inputVehicles) {
        List<String> vehicles = Arrays.stream(inputVehicles.split(","))
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

    private static void raceStart(List<Vehicle> vehicles, int raceRounds) {
        for (int i = 0; i < raceRounds; i++) {
            processRound(vehicles);

            if (i == 0) System.out.println("결과 출력");
            raceResult(vehicles);
        }
        raceWinner(vehicles);
    }

    private static void processRound(List<Vehicle> vehicles) {
        vehicles.forEach(vehicle -> vehicle.moveOrStay(Randoms.pickNumberInRange(0, 9)));
    }

    private static void raceResult(List<Vehicle> vehicles) {
        vehicles.forEach(vehicle -> System.out.println(vehicle.getCurrentDistanceToSymbol()));
        System.out.println();
    }

    private static void raceWinner(List<Vehicle> vehicles) {
        String result = vehicles.stream()
                .filter(vehicle -> vehicle.getCurrentDistance() == Vehicle.MAX_RACE_DISTANCE)
                .map(Vehicle::getVehicleName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}