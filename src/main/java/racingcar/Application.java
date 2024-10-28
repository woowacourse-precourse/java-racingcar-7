package racingcar;

public class Application {
    private final static String INPUT_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_VALIDATION_EXCEPTION_MESSAGE = "자동차 이름 형식을 맞춰주세요. 자동차 이름은 필수 값입니다.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    public static void validateInput(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(INPUT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    public static void inputCarNamePrint(){
        System.out.println(INPUT_PRINT);
    }

    }
}
