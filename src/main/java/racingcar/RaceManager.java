package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager implements RaceManagerInterface{

    private final Car[] participants;
    private final List<List<String>> raceLog = new ArrayList<>();

    public RaceManager(List<String> participantNames) {
        Register register = new Register();
        participants = register.registerParticipants(participantNames);
    }

    @Override
    public void doRace(int times) {
        for (int i = 0; i < times; i++) {
            List<String> oneRapLog = new ArrayList<>();
            for (Car participant : participants) {
                participant.roleDice(MIN_DICE_NUM,MAX_DICE_NUM); //magic numbers need to changed
                oneRapLog.add(participant.getName() + " : " + ("-").repeat(participant.getPosition()));
            }
            raceLog.add(oneRapLog);
        }
    }

    @Override
    public List<List<String>> getLog() {
        return raceLog;
    }
}
