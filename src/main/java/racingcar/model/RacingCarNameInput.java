package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarNameInput {
    private static final String Delimiter = ",";
    private static final String MINIMUM_PLAYER_ERROR_MESSAGE = "최소 플레이어는 2명입니다.";
    private static final int MINIMUM_PLAYER = 2;
    private static final String NAME_DUPLICATED_ERROR_MESSAGE = "중복된 이름이 존재합니다";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5글자를 넘길 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_ONLY_SPACE_ERROR_MESSAGE = "공백만 포함된 이름은 설정할 수 없습니다.";
    String userInput;
    List<String> nameList;

    public RacingCarNameInput(String userInput) {
        this.userInput = userInput;
        nameList = parsingInput(userInput);
        validate();
    }

    private List<String> parsingInput(String input) {

        return List.of(input.split(Delimiter)).stream()
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    private void validate() {
        validateMinimumPlayer();
        validateNameRange();
        validateNameNothing();
        validateSameName();
    }

    private void validateMinimumPlayer() {
        if (nameList.size() < MINIMUM_PLAYER) {
            throw new IllegalArgumentException(MINIMUM_PLAYER_ERROR_MESSAGE);
        }
    }

    private void validateNameRange() {
        for (String name : nameList) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private void validateSameName() {
        Set<String> set = new HashSet<>(nameList);
        if (nameList.size() != set.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private void validateNameNothing() {
        for (String name : nameList) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(NAME_ONLY_SPACE_ERROR_MESSAGE);
            }
        }
    }

    public List<String> getRacingCarNameList() {
        return nameList;
    }

}
