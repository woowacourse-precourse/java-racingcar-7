package racingcar;

import java.util.Arrays;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (Arrays.stream(name.split("")).map(s -> s.charAt(0)).anyMatch(c -> {
            boolean isKorean = (c >= '가' && c <= '힣');
            return Character.isLetter(c) || isKorean;
        })) {
            throw new IllegalArgumentException("이름은 한글과 영어만 가능합니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}