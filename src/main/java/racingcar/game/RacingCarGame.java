package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCars;

public class RacingCarGame {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public String runGame(final List<String> carNames, final int round) {
        appendExecuteResultMessage();
        RacingCars racingCars = RacingCars.fromNames(carNames);

        playRound(round, racingCars);

        List<String> winnersName = racingCars.getWinnersName();
        appendWinnersNameMessage(winnersName);
        return stringBuilder.toString();
    }

    private void appendWinnersNameMessage(List<String> winnersName) {
        stringBuilder.append("최종 우승자 : ").append(String.join(", ", winnersName));
    }

    private void playRound(int round, RacingCars racingCars) {
        List<RacingCar> cars = racingCars.getCars();
        for (int i = 0; i < round; i++) {
            playOneRound(cars);
            cars.forEach(car -> stringBuilder.append(String.format("%s : %s%n", car.getName(), car.getProgress())));
            stringBuilder.append("\n");
        }
    }

    private void playOneRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            car.moveIfRandomNumberIsAbove(pickedNumber);
        });
    }

    private void appendExecuteResultMessage() {
        stringBuilder.append("\n실행결과\n");
    }
}
