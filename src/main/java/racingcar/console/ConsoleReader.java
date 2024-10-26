package racingcar.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConsoleReader {

    public static int readNum() { return Validator.validateNum(Console.readLine());}

    public static String readName(){
        return Validator.validateName(Console.readLine());
    }

    private static class Validator {

        public static int validateNum(String input){
            if(isBlank(input) || !isNumber(input)){
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(input);
        }
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
        private static boolean isNumber(String input){
            return input.matches("^[0-9]*$");
        }
        private static boolean isOversized(String name) {
            return name.length() > 5;
        }

        private static boolean isBlank(String name) {
            return name.isEmpty();
        }
    }
}
