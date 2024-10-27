package racingcar.validator;

public class StringValidator{

    public static void validateAllStringValues(String[] input){
        isSeveralValue(input);
        isEmptyValue(input);
        areAllLetter(input);
        areAllLengthUnderFive(input);
    }

    public static void isSeveralValue(String[] input){
        if(input.length < 2){
            throw new IllegalArgumentException("2개 이상의 자동차를 입력해주세요.");
        }
    }

    public static void isEmptyValue(String[] input){
        for(String value : input){
            if(value==null || value.isEmpty()){
                throw new IllegalArgumentException("공백 문자열이 포함되어 있습니다. : " + value);
            }
        }
    }

    public static void areAllLetter(String[] input){
        for(String value : input){
            if(!value.chars().allMatch(Character::isLetter)){
                throw new IllegalArgumentException("한글과 염문으로 구성된 이름을 입력해주세요. : " + value);
            }
        }
    }

    public static void areAllLengthUnderFive(String[] input){
        for(String value : input){
            if(value.length() >  5){
                throw new IllegalArgumentException("이름의 길이가 5자를 넘습니다. : " + value);
            }
        }
    }

}
