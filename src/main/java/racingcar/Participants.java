package racingcar;

import static racingcar.OutputHandler.changeLine;
import static racingcar.OutputHandler.printFinalWinner;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class Participants {
    private final List<Participant> participantList = new ArrayList<>();

    public Participants(String nameString) {
        String[] names = nameString.split(",");
        for (String name : names) {
            participantList.add(new Participant(name));
        }
    }

    public Participants(List<Participant> participants) {
        this.participantList.addAll(participants);
    }

    public int numberOfParticipants() {
        return this.participantList.size();
    }

    public void raceManyTimes(int raceTimes) {
        validate(raceTimes);
        for (int i = 0; i < raceTimes; i++) {
            raceOneTime();
            printRaceResult();
        }
    }

    private void validate(int raceTimes) {
        if (raceTimes < 1) {
            throw new IllegalArgumentException("시행 횟수는 1회 이상이여야 합니다.");
        }
    }

    public void printWinner() {
        List<String> winnerList = findWinner();
        printFinalWinner(winnerList);
    }

    private List<String> findWinner() {
        return getMaxCount().map(
                        maxMoveValue -> participantList
                                .stream()
                                .filter(value -> value
                                        .getMoveCount() == maxMoveValue)
                                .map(Participant::getName)
                                .toList())
                .orElse(Collections
                        .emptyList());
    }


    private Optional<Integer> getMaxCount() {
        return participantList.stream().map(Participant::getMoveCount)
                .max(Integer::compareTo);
    }

    private void raceOneTime() {
        for (Participant participant : participantList) {
            int random = Randoms.pickNumberInRange(0, 9);
            participant.race(random);
        }
    }

    private void printRaceResult() {
        for (Participant participant : participantList) {
            participant.printStatus();
        }
        changeLine();
    }

}
