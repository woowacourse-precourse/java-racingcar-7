package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Game {
    private final InputHandler inputHandler;

    Game(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    private List<Car> carList = new ArrayList<>();
    private int remainAttempts = 0;

    public void initializeCars() {
        List<String> result = inputHandler.getCarNames();
        carList.addAll(result.stream().map(c -> new Car(c)).collect(Collectors.toList()));
    }

    public void initializeRemainAttempts() {
        remainAttempts = inputHandler.getNumberOfAttempts();
    }

    public void startGame() {
        for (int i = 0; i < remainAttempts; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).move();
                carList.get(j).printCurrentStatus();
            }
        }
    }

    public void printWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            final int currentCarPosition = carList.get(i).getPosition();
            final String currentCarName = carList.get(i).getName();
            if (maxPosition < currentCarPosition) {
                winners.clear();
                winners.add(currentCarName);
                maxPosition = currentCarPosition;
            } else if (maxPosition == currentCarPosition) {
                winners.add(currentCarName);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
