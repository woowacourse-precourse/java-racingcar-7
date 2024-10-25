package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        IOController ioController = new IOController();
        // TODO: 프로그램 구현
        List<String> userList = ioController.userListInput();
        String tryCount = ioController.tryCountInput();

        Validator validator = new Validator();
        validator.validateUsernames(userList);
        validator.isDigit(tryCount);

        ioController.printState();
        Race race = new Race(userList, Integer.parseInt(tryCount));
        race.raceStart();

        ioController.printFinalWinner(race.getRaceWinners());
    }
}
