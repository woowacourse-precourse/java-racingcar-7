package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {



    List<String>getCarNames(String cars){
        return Arrays.stream(cars.split(","))
                .map(String::trim).toList();
    };


/*    initializeCars(List<String> carNames)
    generateRandomNumber()

    canMove(int randomNumber)
    moveCar(Car car, int randomNumber)
    playRound(List<Car> cars)
    getWinners(List<Car> cars)

    validateCarName(String carName)
    validateAttemptCount(String attemptCount)*/

    public static void main(String[] args) {
        String input = Console.readLine();
    }
}
