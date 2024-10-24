package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> participants = new ArrayList<>();


    public Game(List<String> carNamesList, int gameRepeat) {
        registerParticipants(carNamesList);
    }

    private void registerParticipants(List<String> carNamesList) {
        carNamesList.forEach(carName -> participants.add(new Car(carName, 0)));
    }

}
