package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;

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
    

    public int movingForwards() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        } else {
            return 0;
        }

    }


}
