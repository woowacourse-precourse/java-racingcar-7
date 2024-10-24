package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager implements RaceManagerInterface{

    private final Car[] participants;
    private final List<List<String>> raceLog = new ArrayList<>();

    public RaceManager(List<String> participantNames) {
        Register register = new Register(); //do i really need Register class?
        participants = register.registerParticipants(participantNames);
    }

    @Override
    public void doRace(int times) {
        for (int i = 0; i < times; i++) {
            newRap();
            for (Car participant : participants) {
                participant.roleDice(MIN_DICE_NUM,MAX_DICE_NUM);
                writeLog(participant.getName() + " : " + ("-").repeat(participant.getPosition()));
            }
        }
    }

    @Override
    public List<List<String>> getLog() {
        return raceLog;
    }

    @Override
    public List<String> getWinner() {
        List<Car> fastest = new ArrayList<>();
        for (Car car : participants) {
            if (fastest.isEmpty() || car.isDrawWith(fastest.getFirst())) {
                fastest.add(car);
            } else if (car.isFasterThan(fastest.getFirst())) {
                fastest = new ArrayList<>();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : fastest) {
            winners.add(car.getName());
        }
        return winners;
    }

    private void writeLog(String log) {
        raceLog.getLast().addLast(log);
    }

    private void newRap() {
        raceLog.addLast(new ArrayList<>());
    }
}
