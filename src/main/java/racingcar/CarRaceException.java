package racingcar;
import java.util.regex.*;

public class CarRaceException {
    public static void validateEmptyInput(String input){
        if(input.matches("\\s*")){
            throw new IllegalArgumentException("공백이나 빈 문자열은 유효한 이름이 아닙니다.\n 입력값 : " + input);
        }
    }

    public static void ensureAtLeastTwoNames(String input){
        if(input.matches("\\s*[a-zA-Z]\\w*")){
            throw new IllegalArgumentException("두 개 이상의 이름을 쉼표(,)로 구분하여 입력해 주세요.\n 입력값 : " + input);
        }
    }

    public static void validateDelimiter(String input){
        if(!input.contains(",")){
            throw new IllegalArgumentException("쉼표(,)를 구분자로 사용해 주세요.\n 입력값 : " + input);
        }
    }

    public static void validateNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.\n 입력값 : " + name);
        }
    }

    public static int validateIntegerConversion(String input){
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("'시도할 횟수'는 숫자로 입력해야 합니다.\n 입력값 : " + input);
        }
    }

    public static void checkNameRedundancy(String[] names){
        String temp = "";
        for (String name : names) {
            if(temp.equals(name)){
                throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
            }
            temp = name;
        }
    }

    public static void noNumberStartingName(String name){
        Pattern pattern = Pattern.compile("^[0-9!@#$%^&*]");
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()){
            throw new IllegalArgumentException("이름은 숫자 또는 특수문자로 시작할 수 없습니다.");
        }
    }
}
