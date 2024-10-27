package racingcar.util;

public class IntConverter {
    private IntConverter() {
    }

    public static long StringToInt(String string) {
        int parsedLong;

        try {
            parsedLong = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            checkNumberFormat(e);
            throw new IllegalArgumentException("입력값이 int 범위를 넘어갔습니다.");
        }

        if (parsedLong <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상입니다.");
        }

        return parsedLong;
    }

    private static void checkNumberFormat(NumberFormatException e) {
        String message = e.getMessage();
        String errorInput = message.substring(message.indexOf(':') + 3, message.length() - 1);

        for (int i = 0; i < errorInput.length(); i++) {
            if (!Character.isDigit(errorInput.charAt(i))) {
                throw new IllegalArgumentException("구분자 이외의 문자가 수식에 포함되있습니다.");
            }
        }
    }
}
