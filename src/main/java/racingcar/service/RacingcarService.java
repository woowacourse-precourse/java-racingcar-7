package racingcar.service;

import java.util.List;
public class RacingcarService {

    public List<String> parseCarName(String rawCarName) {
        return List.of(rawCarName.split(","));
    }

    public void validateCarName(List<String> parsedCarName) {
        for (String carName : parsedCarName) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("이름을 입력해 주세요.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
