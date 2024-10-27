package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameService {

    GameRepository gameRepository = new GameRepository();


    public void setCarsNames(String input) {

        String delimiter = ",";
        List<String> splitNames = List.of(input.split(delimiter));
        gameRepository.setCarName(splitNames);


    }


    public void setNumberOfRounds(String input) {

        int round = Integer.parseInt(input);
        gameRepository.setRound(round);

    }


    public Map<String, Integer> setCarPositionOnTheLine() {

        return gameRepository.getAllNames().stream()
                .collect(Collectors.toMap(name -> name, name -> 0));
    }

    public void roundOnRound(Map<String, Integer> cars) {

        String gauge = "-";
        for (String car : cars.keySet()) {
            int currentPosition = cars.get(car);
            int progress = movingForwards();
            currentPosition += progress;
            cars.put(car, currentPosition);
            System.out.println(car + " : " + gauge.repeat(currentPosition));
        }

        System.out.println();

    }

    public int movingForwards() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        } else {
            return 0;
        }

    }


}
