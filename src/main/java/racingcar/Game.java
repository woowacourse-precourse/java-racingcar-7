package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> participants = new ArrayList<>();
    private int gameRepeat;

    public Game(List<String> carNamesList, int gameRepeat) {
        registerParticipants(carNamesList);
        this.gameRepeat = gameRepeat;
    }

    private void registerParticipants(List<String> carNamesList) {
        carNamesList.forEach(carName -> participants.add(new Car(carName, 0)));
    }

    public void moveCar() {
        for (Car participant : participants) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                participant.move();
            }
        }
    }
}
