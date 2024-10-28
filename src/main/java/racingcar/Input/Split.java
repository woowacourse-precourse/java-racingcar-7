package racingcar.Input;

public class Split {

    // ","를 기준으로 나누기
    public static String[] splitByComma(String target) {
        String [] arr = target.split(",");
        return arr;
    }
}
