package racingcar.parser;

import racingcar.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {

    public static List<String> parseNames(String names){
        if (names == null || names.trim().isEmpty()) {
            throw new InputException("빈 문자열입니다.");
        }
        List<String> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names, ",");

        while (st.hasMoreTokens()){
            nameList.add(st.nextToken().trim());
        }

        return nameList;
    }


    public static int parseTurns(String number){
        if (number == null || number.trim().isEmpty()) {
            throw new InputException("빈 문자열입니다.");
        }
        try{
            return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new InputException("숫자 변환에 실패하였습니다.");
        }
    }

}
