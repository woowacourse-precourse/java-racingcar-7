package separator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputSeparator {
    private static final Integer MAX_NAME_LENGTH = 5;

    public static List<String> split(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("input is empty");
        }

        List<String> splitItems = List.of(text.split(","));

        if (containsEmpty(splitItems)) {
            throw new IllegalArgumentException("split value is empty");
        }
        if (hasDuplicateNames(splitItems)) {
            throw new IllegalArgumentException("duplicate input");
        }
        if (!areNameLengthsValid(splitItems)) {
            throw new IllegalArgumentException("name is too long. max length is " + MAX_NAME_LENGTH);
        }

        return splitItems;
    }

    private static boolean containsEmpty(List<String> splitTexts) {
        return splitTexts.stream().anyMatch(text -> text.trim().isEmpty());
    }

    private static boolean hasDuplicateNames(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private static boolean areNameLengthsValid(List<String> nameList) {
        return nameList.stream().allMatch(string -> string.length() <= MAX_NAME_LENGTH);
    }
}
