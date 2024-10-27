package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> participants = new ArrayList<>();

    private final String DISTANCE_INDICATOR = "-";
    private final String NAME_DISTANCE_SPLIT = " : ";

    private final int MOVE_STANDARD_NUMBER = 4;

    public Game(List<String> carNamesList) {
        registerParticipants(carNamesList);
    }

    private void registerParticipants(List<String> carNamesList) {
        carNamesList.forEach(carName -> participants.add(new Car(carName)));
    }

    public void moveCar() {
        for (Car participant : participants) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= MOVE_STANDARD_NUMBER) {
                participant.move();
            }
        }
    }

    public void printProgress() {
        StringBuilder printMessage = new StringBuilder();

        for (Car participant : participants) {
            printMessage.setLength(0);

            String participantName = participant.getName();
            int participantDistance = participant.getDistance();

            printMessage.append(participantName);
            printMessage.append(NAME_DISTANCE_SPLIT);
            printMessage.append(DISTANCE_INDICATOR.repeat(participantDistance));

            System.out.println(printMessage);
        }
        System.out.println();
    }

    private List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car participant : participants) {
            int participantDistance = participant.getDistance();
            if (maxDistance < participantDistance) maxDistance = participantDistance;
        }

        for (Car participant : participants) {
            int participantDistance = participant.getDistance();
            if (participantDistance == maxDistance) winners.add(participant.getName());
        }
        return winners;
    }

    public void printWinners() {
        StringBuilder printMessage = new StringBuilder();
        List<String> winners = findWinners();

        printMessage.append("최종 우승자 : ");
        printMessage.append(winners.getFirst());
        winners.removeFirst();
        if (!winners.isEmpty()) {
            winners.forEach((winner) -> {
                printMessage.append(", ");
                printMessage.append(winner);
            });
        }

        System.out.println(printMessage);
    }
}
