package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String[] readInputName() {
        String raedLine = Console.readLine();
        raedLine += ",\0";
        String[] readLinesWithNULL = raedLine.split(",");
        String[] readLines = new String[readLinesWithNULL.length-1];
        for ( int i = 0; i < readLinesWithNULL.length-1; i++ ) {
            readLines[i] = readLinesWithNULL[i];
        }

        for ( int i = 0; i < readLines.length; i ++ ) {
            if (readLines[i].isBlank()) {
                throw new IllegalArgumentException("이름을 입력하지 않았거나 이름에 공백만 입력됐어요");
            }
            if (readLines[i].length() > 5) {
                    throw new IllegalArgumentException("이름은 5자 이하여야 해요");
            }
            for ( int j = i + 1; j < readLines.length; j ++ ) {
                if (readLines[i].equals(readLines[j])) {
                    throw new IllegalArgumentException("중복된 이름이 입력됐어요");
                }
            }
        }

        return readLines;
    }

    public static int readInputRound() {
        double doubleReadLine = Double.parseDouble(Console.readLine());
        if (doubleReadLine % 1 != 0.0) {
            throw new IllegalArgumentException("자연수만 입력할 수 있어요");
        }
        if (doubleReadLine > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("int 범위 안의 값만 입력할 수 있어요");
        }

        int readLine = (int) doubleReadLine;
        if (readLine < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없어요");
        }

        return readLine;
    }
}
