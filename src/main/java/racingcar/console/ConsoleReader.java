package racingcar.console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConsoleReader {

    public static String readName(String input){
        return Validator.validateName(input);
    }

    private static class Validator {
        public static String validateName(String input){
            List<String> nameList = Arrays.stream(input.split(",")).toList();
            for (String name : nameList) {
                if(isBlank(name) || isOversized(name)){
                    throw new IllegalArgumentException();
                }
            }
            if(isDuplicated(nameList)){
                throw new IllegalArgumentException();
            }
            return input;
        }

        private static boolean isDuplicated(List<String> nameList) {
            HashSet<String> nameSet = new HashSet<>(nameList);
            return nameList.size() != nameSet.size();
        }

        private static boolean isOversized(String name) {
            return name.length() > 5;
        }

        private static boolean isBlank(String name) {
            return name.isEmpty();
        }
    }
}
