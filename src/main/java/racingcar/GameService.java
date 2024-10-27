package racingcar;

import java.util.List;

public class GameService {

    GameRepository gameRepository = new GameRepository();


    public void setCarsNames(String input) {

        String delimiter = ",";
        List<String> splitNames = List.of(input.split(delimiter));
        gameRepository.setCarName(splitNames);


    }
}
