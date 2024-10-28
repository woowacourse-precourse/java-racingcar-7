package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Racing {
    private List<String> carNames = new ArrayList<>();
    private int round;
    private Map<String, String> carPositions = new HashMap<>();

    public void setCarName() {
        Printer.printInputCarNames();
        String inputCarName = Console.readLine();
        this.carNames = List.of(inputCarName.split(","));

        validateCarNames();

        for (String carName : carNames) {
            carPositions.put(carName, "");
        }
    }

    private void validateCarNames() {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("최소 2대의 자동차 이름을 입력해야 합니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다: " + carName);
            }
        }
    }

    public void setRound() {
        Printer.promptRound();
        String inputRound = Console.readLine();

        try {
            this.round = Integer.parseInt(inputRound);

            if (this.round < 1) {
                throw new IllegalArgumentException("라운드는 1 이상의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드는 정수여야 합니다.");
        }
    }

    private void forwardCar(int randomNumber, Map<String, String> carPositions, String carName){
        if (randomNumber >= 4) {
            carPositions.put(carName, carPositions.get(carName) + "-");
        }
    }
    public void inGame() {
        for (int i = 1; i <= round; i++) {
            for (String carName : carNames) {
                int randomNumber = pickNumberInRange(0, 9);

                forwardCar(randomNumber, carPositions, carName);
            }
            printCarStatuses();
        }
        winners();
    }

    private void printCarStatuses() {
        Printer.printNewLine();

        for (String carName : carNames) {
            String status = carPositions.get(carName);
            Printer.printCarStatus(carName, status);
        }
    }

    private void winners() {
        int maxStars = 0;

        for (String status : carPositions.values()) {
            maxStars = Math.max(maxStars, status.length());
        }

        List<String> winners = new ArrayList<>();
        for (String carName : carNames) {
            String currentCarPosition = carPositions.get(carName);

            if (currentCarPosition.length() == maxStars) {
                winners.add(carName);
            }
        }

        Printer.printWinners(winners);
    }
}