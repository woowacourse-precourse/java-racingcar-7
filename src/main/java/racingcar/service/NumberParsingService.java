package racingcar.service;

public class NumberParsingService {
    public int parseNum(String stringNum) {
        if (stringNum.length() > 5) {
            throw new IllegalArgumentException("시도 횟수는 10만 아래로 설정해 주세요");
        }
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < stringNum.length(); i++) {
            char ch = stringNum.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
            number.append(ch);
        }
        return Integer.parseInt(number.toString());
    }
}
