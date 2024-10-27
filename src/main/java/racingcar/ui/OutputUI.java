package racingcar.ui;

public class OutputUI {

    /**
     * 우승자 목록을 출력합니다.
     *
     * @param template 출력 템플릿
     * @param args     우승자 목록
     */
    public static void printResult(String template, String... args) {
        String formattedMessage = formatMessage(template, args);

        System.out.println(formattedMessage);
    }

    /**
     * 메시지를 템플릿과 인자를 사용해 포맷팅합니다.
     *
     * @param template 출력 템플릿
     * @param args     인자 목록
     * @return 포맷팅된 문자열
     */
    private static String formatMessage(String template, String... args) {
        try {
            return String.format(template, (Object[]) args);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 인자가 템플릿과 일치하지 않습니다: " + e.getMessage());
        }
    }

}
