package racingcar.utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtility {
    private final static String CONTAIN_SPECIAL_CHARACTER_REGEX = ".*[^가-힣a-zA-Z0-9].*";

    public static List<String> splitStringToList(String input){
        String[] names = input.split(",");
        return Arrays.asList(names);
    }

    public static boolean containsSpecialCharacter(String input) {
        return input.matches(CONTAIN_SPECIAL_CHARACTER_REGEX);
    }

    public static String listToSplitStr(List<String> list) {
        if(list.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : list){
            stringBuilder.append(string).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    public static boolean isDuplicateStrExists(List<String> strings) {
        Set<String> duplicateCheckSet = new HashSet<>();
        for(String string : strings){
            if(duplicateCheckSet.contains(string)) return true;
            duplicateCheckSet.add(string);
        }
        return false;
    }
}
