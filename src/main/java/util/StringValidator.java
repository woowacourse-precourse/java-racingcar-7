package util;

public class StringValidator {
    public static void checkCarNames(String nameString){
        String[] carNames = nameString.split(",");
        for(String carName : carNames)
            checkRightCarNameSize(carName);

    }

    private static void checkRightCarNameSize(String carName){
        if(carName.length() > 5 || carName.isEmpty())
            throw new IllegalArgumentException("자동차의 이름이 적절하지 않습니다.");

    }

    public static void checkNotNull(String text){
        if(text == null)
            throw new IllegalArgumentException("입력한 문자열이 null 입니다.");

    }
    public static void checkPositiveIntValue(String numString){
        if(!numString.matches("[1-9]\\d*"))
            throw new IllegalArgumentException("양의 정수 값만 입력할 수 있습니다.");

    }
}
