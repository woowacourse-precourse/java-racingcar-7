package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarRace;
import racingcar.util.InputValidator;

public class Application {
    public static void main(String[] args) {
       String cars = Console.readLine();
       String count = Console.readLine();
       InputValidator.check(cars, count);
       CarRace carRace = new CarRace();
       carRace.race(cars, count);
    }
}
