package racingcar;

public class ExceptionManager {

    private String input = "";
    private String[] inputCars;
    private int NUMBER;

    ExceptionManager(String input, String[] inputCars, int NUMBER){
        this.input = input;
        this.inputCars = inputCars;
        this.NUMBER = NUMBER;
    }

    // 빈값 확인
    private void checkInputCarsIsNull(){
        if(input.equals("")){
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }

    // NUMBER 0또는 음수인지 확인
    private void checkWrongInputNumber(){
        if(NUMBER <= 0){
            throw new IllegalArgumentException("양수를 입력해야합니다.");
        }
    }

    private void checkWrongWord(){
        // 다른 구분자나 숫자가 포함되어 있는지 확인하기
        if(!input.matches("^[a-zA-Z,]*$")) {
            throw new IllegalArgumentException("문자와 구분자','외에 다른문자가 포함되어 있습니다.");
        }
    }

    private void checkWrongDelimiter(){
        // input의 delimiter 위치 확인(','가 맨앞에 오거나 겹치는 경우)
        for(String inputCar : inputCars) {
            if(inputCar.isEmpty()){
                throw new IllegalArgumentException("구분자가 겹쳐있거나 문자열 맨앞에 위치해 있습니다.");
            }
        }
        // input의 delimiter 위치 확인(','가 맨앞 맨뒤에 있는 경우)
        if(input.charAt(input.length() - 1) == ','){
            throw new IllegalArgumentException("구분자가 문자열 맨뒤에 위치해 있습니다.");
        }
    }

    private void checkWrongLength(){
        // input의 차 이름이 5글자 이하인지 확인
        for(String inputCar : inputCars) {
            checkNumOfCarName(inputCar);
        }
    }

    private void checkNumOfCarName(String inputCar) {
        int MAX_NUM_OF_CAR_NAME = 5;
        if(inputCar.length() > MAX_NUM_OF_CAR_NAME){
            throw new IllegalArgumentException("자동차 이름이 5글자 이하여야합니다.");
        }
    }

    public void checkException(){
        checkInputCarsIsNull();
        checkWrongInputNumber();
        checkWrongWord();
        checkWrongDelimiter();
        checkWrongLength();
    }
}
