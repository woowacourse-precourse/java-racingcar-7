package racingcar;

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
        for (int i = 0; i < raceTimes; i++) {
            raceOneTime();
            printRaceResult();
        }
    }

    public void printWinner() {
        List<String> winnerList = getMaxCount().map(
                        maxMoveValue -> participantList
                                .stream()
                                .filter(value -> value
                                        .getMoveCount() == maxMoveValue)
                                .map(Participant::getName)
                                .toList())
                .orElse(Collections
                        .emptyList());
        System.out.println("최종 우승자 : " + String.join(",", winnerList));
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
        System.out.println();
    }
}
