package racingcar;

import java.util.List;

public class Register{

    public Car[] registerParticipants(List<String> names) {
        Car[] participants = new Car[names.size()];
        for (int i = 0; i < names.size(); i++) {
            participants[i] = new Car(names.get(i));
        }
        return participants;
    }
}
