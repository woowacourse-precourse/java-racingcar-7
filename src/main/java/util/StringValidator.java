package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringValidator {
    public static void checkCarNames(String nameString){
        String[] carNames = StringParser.parseString(nameString, ",");
        for(String carName : carNames)
            checkRightCarNameSize(carName);

    }

    private static void checkRightCarNameSize(String carName){
        if(carName.length() > 5 || carName.isEmpty())
            throw new IllegalArgumentException("자동차의 이름이 적절하지 않습니다.");

    }

    public static void checkNotNullOrEmpty(String text){
        if(text == null || text.isEmpty())
            throw new IllegalArgumentException("입력한 문자열이 없습니다.");

    }
    public static void checkPositiveIntValue(String numString){
        if(!numString.matches("[1-9]\\d*"))
            throw new IllegalArgumentException("양의 정수 값만 입력할 수 있습니다.");

    }

    public static void checkDuplicatedName(String nameString){
        String[] carNames = StringParser.parseString(nameString, ",");

        Set<String> nameDuplicator = new HashSet<>(Arrays.asList(carNames));

        if(carNames.length != nameDuplicator.size())
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
    }
}
