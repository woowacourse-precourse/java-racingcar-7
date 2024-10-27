package racingcar.validator;

import racingcar.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputValidator {

    public static List<String> parseNames(String names){
        checkNotEmpty(names);

        List<String> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names, ",");

        while (st.hasMoreTokens()){
            String name = st.nextToken().trim();
            isLengthUnderFive(name);
            nameList.add(name);
        }
        return nameList;
    }


    public static int parseTurns(String number){
        checkNotEmpty(number);

        try{
            return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new InputException("숫자 변환에 실패하였습니다.");
        }
    }

    private static void isLengthUnderFive(String name){
        if (name.length() > 5) {
            throw new InputException("이름의 길이는 5자 이하여야 합니다.");
        }
    }


    private static void checkNotEmpty(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new InputException("빈 문자열입니다.");
        }
    }



}
