package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarNameInput {
    String userInput;
    List<String> nameList;

    public RacingCarNameInput(String userInput) {
        this.userInput = userInput;
        nameList = parsingInput(userInput);
        validate();
    }

    private List<String> parsingInput(String input) {

        return List.of(input.split(","))
                .stream()
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
        if (nameList.size() <= 1) {
            throw new IllegalArgumentException("최소 플레이어는 2명입니다.");
        }
    }

    private void validateNameRange() {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자를 넘길 수 없습니다.");
            }
        }
    }

    private void validateSameName() {
        Set<String> set = new HashSet<>(nameList);
        if (nameList.size() != set.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    private void validateNameNothing() {
        for (String name : nameList) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("공백만 포함된 이름은 설정할 수 없습니다.");
            }
        }
    }

    public List<String> getRacingCarNameList() {
        return nameList;
    }

}
