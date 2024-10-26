package racingcar.validation;

import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {

    private static final String NAME_ERROR_MESSAGE = "이름 입력 오류입니다.";

    public static void validateNameString(List<String> names){
        validateIsEmpty(names);
        validateNameCount(names);
        validateDuplicateNames(names);

        names.forEach(name ->{
            validateHasEmptyName(name);
            validateNameLength(name);
        });
    }

    private static void validateIsEmpty(List<String> names) {
        if(names.isEmpty())
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
    }

    private static void validateNameCount(List<String> names) {
        if(names.size()>10)
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
    }

    private static void validateDuplicateNames(List<String> names) {
        boolean hasDuplicates = names.stream()
                .map(String::trim)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count > 1);

        if (hasDuplicates) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static void validateHasEmptyName(String name) {
        if(name.trim().isEmpty())
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
    }

    private static void validateNameLength(String name) {
        if(name.trim().length()>5)
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
    }
}
