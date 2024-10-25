package racingcar.global.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InputValidator {
    public enum ValidationMode {
        CAR_NAME(1, 5, InputValidator::validateCarName),
        CAR_COUNT(2, 100, InputValidator::validateCarCount),
        GAME_COUNT(1, 1000, InputValidator::validateGameCount);

        public final int min;
        public final int max;
        private final Consumer<String> validator;

        ValidationMode(int min, int max, Consumer<String> validator) {
            this.min = min;
            this.max = max;
            this.validator = validator;
        }
    }

    public static void validate(ValidationMode mode, String input) {
        Map<ValidationMode, Consumer<String>> modeMap = new HashMap<>();

        for(ValidationMode validationMode : ValidationMode.values()) {
            modeMap.put(validationMode, validationMode.validator);
        }

        Consumer<String> validator = modeMap.get(mode);
        validator.accept(input);
    }

    private static void validateCarName(String input) {
        String[] names = input.split(",");
        for(String name : names) {
            if(name.length() < ValidationMode.CAR_NAME.min || name.length() > ValidationMode.CAR_NAME.max)
                throw new IllegalArgumentException("자동차 이름은 " + ValidationMode.CAR_NAME.min + "자 이상 " +
                        ValidationMode.CAR_NAME.max + "자 이하만 가능합니다.");

        }
    }

    private static void validateCarCount(String input) {
        String[] names = input.split(",");

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차를 등록해주세요.");
        }
        if(names.length < ValidationMode.CAR_COUNT.min) {
            throw new IllegalArgumentException("자동차는 최소 "+ValidationMode.CAR_COUNT.min +"개 이상 등록해야합니다.");
        }
        if(names.length > ValidationMode.CAR_COUNT.max) {
            throw new IllegalArgumentException("자동차는 최대 "+ValidationMode.CAR_COUNT.max +"개 까지 등록 가능합니다.");
        }
    }

    private static void validateGameCount(String input) {
        try {
            int n = Integer.parseInt(input);
            if (n < 0) throw new IllegalArgumentException("양의 정수를 입력해주세요");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}