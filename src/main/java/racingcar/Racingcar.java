package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racingcar {
    private List<Car> carList = new ArrayList<>();

    public void splitInputValue(String input_value) {
        String[] carNames = input_value.split(Contants.INPUT_SPLIT_CHAR);
        for (String carName : carNames) {
            ErrorValidator.carName(carName);
            carList.add(new Car(carName));
        }
    }

    public void startGames(int game_count) {
        System.out.println(Contants.OUTPUT_NOTICE_GAME_RESULT);
        for (int i = 0; i < game_count; i++) {
            new Game(carList).play();
            printGameResult();
        }
    }

    public void printGameResult() {
        for (Car car : carList) {
            String result = car.getName()
                    + Contants.OUTPUT_COLON_CAHR
                    + Contants.OUTPUT_DISTANCE_CHAR.repeat(car.getDistance());
            System.out.println(result);
        }
        System.out.println();
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : carList) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    public List<Car> findWinner() {
        List<Car> winnerList = new ArrayList<>();
        int maxDistance = findMaxDistance();
        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public void printWinner(List<Car> winnerList) {
        List<String> str_winnerList = new ArrayList<>();
        for (Car cars : winnerList) {
            str_winnerList.add(cars.getName());
        }
        String winners_name = String.join(", ", str_winnerList);
        System.out.println(winners_name);
    }

    public void play() {
        System.out.println(Contants.INPUT_NOTICE_CAR_NAMES);
        String input_value = Console.readLine();
        splitInputValue(input_value);

        System.out.println(Contants.INPUT_NOTICE_GAME_TIMES);
        String input_value2 = Console.readLine();
        ErrorValidator.gameCount(input_value2);

        int game_count = Integer.parseInt(input_value2);
        startGames(game_count);

        List<Car> winnerList = findWinner();
        System.out.print(Contants.OUTPUT_NOTICE_WINNER_RESULT
                + Contants.OUTPUT_COLON_CAHR);
        printWinner(winnerList);
    }


}
