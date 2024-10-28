package racingcar;

import java.util.List;
import racingcar.dto.GameDto;

public class GameRepository {

    private final GameDto gameDto = new GameDto();

    public void setCarsNames(String input) {

        try {
            inputValidator(input);
            String delimiter = ",";
            List<String> splitNames = List.of(input.split(delimiter));
            nameLengthValidator(splitNames);
            gameDto.setCarName(splitNames);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }


    }

    public void setNumberOfRounds(String input) {

        try {
            inputValidator(input);
            int round = Integer.parseInt(input);
            gameDto.setRound(round);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public int roundOfGame() {
        return gameDto.getRound();
    }

    public List<String> getAllNames() {
        return gameDto.getCarNames();
    }

    public void selectWinner(String input) {
        gameDto.setWinner(input);
    }

    public List<String> findWinner() {
        return gameDto.getWinner();
    }

    private void inputValidator(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private void nameLengthValidator(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("ERROR : 5자 이하의 이름만 입력 가능합니다.");
            }
        }
    }


}
