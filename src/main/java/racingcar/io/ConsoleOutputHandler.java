package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.vehicle.Vehicle;

public class ConsoleOutputHandler {

    public void printCarNameInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInstruction() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printProgressDegree(Vehicle vehicle) {
        System.out.print(vehicle.getVehicleName() + " : ");
        printProgressLine(vehicle.getForwardCount());
    }

    public void printWinner(List<Vehicle> winners) {
        String winnerMembers;
        winnerMembers = winnersListToString(winners);

        System.out.print("최종 우승자 : ");
        System.out.println(winnerMembers);

    }

    public void printProgressLine(int forwardCount) {
        for (int i = 0; i < forwardCount; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static String winnersListToString(List<Vehicle> winners) {
        String winnerMembers;
        if (winners.size() > 1) {
            winnerMembers = String.join(", ", winners.stream()
                    .map(Vehicle::getVehicleName)
                    .collect(Collectors.toList()));
        }
        else  {
            winnerMembers = winners.getFirst().getVehicleName();
        }
        return winnerMembers;
    }
}
