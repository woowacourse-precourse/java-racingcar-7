package racingcar.console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConsoleReader {

    public static String readName(String input){
        return Validator.validate(input);
    }

    private static class Validator {
        public static String validate(String input){
            List<String> nameList = Arrays.stream(input.split(",")).toList();
            for (String name : nameList) {
                isBlank(name);
                isOversized(name.length() > 5);
            }
            isDuplicated(nameList);
            return input;
        }

        private static void isDuplicated(List<String> nameList) {
            HashSet<String> nameSet = new HashSet<>(nameList);
            if(nameList.size() != nameSet.size()){
                throw new IllegalArgumentException();
            }
        }

        private static void isOversized(boolean name) {
            if (name) {
                throw new IllegalArgumentException();
            }
        }

        private static void isBlank(String name) {
            if(name.isEmpty()){
                throw new IllegalArgumentException();
            }
        }
    }
}
