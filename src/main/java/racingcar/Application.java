package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

public class Application {
    private static final String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_MAX_COUNT = 10;
    private static final int CAR_MIN_COUNT = 2;


    private static String getInput(){
        String inputString = Console.readLine();
        Console.close();
        return inputString;
    }

    private static ArrayList<String> splitCarNames(String input){
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        return carNames;
    }

    private static String isEnglishOnlyName(String carName){
        if(!Pattern.matches("[a-zA-Z]+", carName)){
            throw new IllegalArgumentException("자동차 이름은 알파벳으로만 구성되어야 합니다.");
        }
        return carName.toLowerCase();
    }

    private static void isValidlengthName(String carName){
        if (carName.length() > CAR_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
    private static void validCarNames(ArrayList<String> carNames){
        for(int i=0; i<carNames.size(); i++){
            carNames.set(i,isEnglishOnlyName(carNames.get(i)));
            isValidlengthName(carNames.get(i));
        }
    }

    private static void validCarCount(ArrayList<String> carNames){
        if ((carNames.size() < CAR_MIN_COUNT) || (carNames.size() > CAR_MAX_COUNT)){
            throw new IllegalArgumentException("자동차 대수는 2대 이상 10대 이하여야 합니다.");
        }
    }

    private static void checkDuplicateName(ArrayList<String> carNames){
        LinkedHashSet<String> carNamesSet  = new LinkedHashSet<>(carNames);
        if (carNamesSet.size() != carNames.size()){
            throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.(대문자와 소문자는 동일하게 인식됩니다.)");
        }
    }

    private static ArrayList<String> getCarNames(){
        String inputString = getInput();
        ArrayList<String> carNames = splitCarNames(inputString);
        validCarCount(carNames);
        validCarNames(carNames);
        checkDuplicateName(carNames);
        return carNames;
    }

    public static void main(String[] args) {
        System.out.println(START_TEXT);
        getCarNames();
    }
}
