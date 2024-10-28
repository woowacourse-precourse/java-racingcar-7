package racingcar.util;


import java.util.ArrayList;

public class DataTransFormer {
    private DataTransFormer() {}

    // 단순히 문자열을 정수로 변환해 반환한다
    public static int makeStringToInt(String string) {
        return Integer.parseInt(string);
    }

    // 숫자를 입력하면 전진 상황 문자열로 바꿔서 출력한다
    public static String makeIntToRacingResult(int mile) {
        return "-".repeat(mile);
    }

    public static String makeJoinedString(ArrayList<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : stringList) {
            stringBuilder.append(str).append(", ");
        }

        String resultString = stringBuilder.toString();
        return resultString.substring(0, resultString.length()-2);
    }
}
