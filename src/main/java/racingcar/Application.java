package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> userList = IOController.userListInput();
        String tryCount = IOController.tryCountInput();

        Validator validator = new Validator();
        validator.validateUsernames(userList);
        validator.isDigit(tryCount);

        IOController.printState();
        Race race = new Race(userList, Integer.parseInt(tryCount));
        race.raceStart();

        IOController.printFinalWinner(race.getRaceWinners());
    }
}
