package racingcar.validator;

public class InputValidator {

    public boolean checkNameIsEmpty(String name) {
        return hasNoInput(name);
    }

    public boolean checkNameIsLongerThanFive(String name) {
        return checkInputLength(name);
    }

    public boolean checkNameIncludeNumber(String name) {
        return includeNumber(name);
    }

    public boolean checkNameHasNameBehindComma(String name) {
        return NoNameBehindComma(name);
    }

    public boolean checkTryNumberIsNotNumber(String tryNumber) {
        return isNotNumber(tryNumber);
    }

    public boolean checkTryNumberIsNotInteger(String tryNumber) {
        return isNotInteger(tryNumber);
    }


    private boolean hasNoInput(String input) {
        //문자열이 비어있으면 true, 아니면 false
        return input.isEmpty();
    }

    //문자열 길이가 5이하면 true, 5보다 크면 false
    private boolean checkInputLength(String input) {
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    //숫자가 있는 이름이 있으면 true, 없으면 false
    private boolean includeNumber(String input) {
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            if (checkHasNumber(name)) {
                return true;
            }
        }
        return false;
    }

    //이름에 숫자가 있는지 확인
    private static boolean checkHasNumber(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //쉼표뒤에 이름이 없으면 true, 있으면 false
    private boolean NoNameBehindComma(String input) {
        int commaCount = countComma(input);
        String[] splitInput = input.split(",");
        //쉼표 갯수가 이름 갯수보다 많으면 쉼표뒤에 이름이 없음
        if (commaCount >= splitInput.length || checkEmptyName(splitInput)) {
            return true;
        }
        return false;
    }

    //이름 배열에 비어있는 이름이 있는지 확인
    private static boolean checkEmptyName(String[] splitInput) {
        for (String name : splitInput) {
            if (name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    //쉼표 갯수를 세는 메소드
    private static int countComma(String input) {
        int commaCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                commaCount++;
            }
        }
        return commaCount;
    }

    //시도 횟수가 숫자가 아니면 true, 숫자면 false
    private boolean isNotNumber(String number) {
        char tryNumber = number.charAt(0);
        if (Character.isDigit(tryNumber)) {
            return false;
        }
        return true;
    }

    //시도 횟수가 1이상의 정수가 아니면 true, 숫자면 false
    private boolean isNotInteger(String number) {
        if (Integer.parseInt(number) >= 1) {
            return false;
        }
        return true;
    }
}
