package separator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Separator {
public class InputSeparator {

    public static List<String> split(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("input is empty");
        }

        List<String> splitItems  = List.of(text.split(","));

        if (isContainEmpty(splitItems)) {
            throw new IllegalArgumentException("split value is empty");
        }
        if (isNameDuplicate(splitItems)) {
            throw new IllegalArgumentException("duplicate input");
        }

        return splitItems;
    }

    private static boolean isContainEmpty(List<String> splitTexts) {
        for (String text : splitTexts) {
            if (text.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNameDuplicate(List<String> nameList) {
        Set<String> uniqueNames = new HashSet<>(nameList);
        return uniqueNames.size() != nameList.size();
    }
}
