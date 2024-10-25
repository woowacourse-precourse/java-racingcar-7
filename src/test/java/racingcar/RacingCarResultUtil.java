package racingcar;

public class RacingCarResultUtil {
    private static final String WINNER_FORMAT = "우승자 : %s\n";
    private static final String WINNER_SEPARATOR = ", ";

    //중간 결과 메세지를 생성하는 메소드
    public static String generateIntermediateResultMessage(int playerCount, String... args) {
        StringBuilder result = new StringBuilder();

        //플레이어 이름과 데이터 분리
        String[] names = new String[playerCount];
        System.arraycopy(args, 0, names, 0, playerCount);

        int rounds = (args.length - playerCount) / playerCount;

        // 각 라운드별로 결과 생성
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < playerCount; j++) {
                String name = names[j];
                int move = Integer.parseInt(args[playerCount + i * playerCount + j]);

                result.append(name).append(" : ");
                result.append("-".repeat(move)).append("\n");
            }
            result.append("\n"); // 라운드 간 구분
        }

        return result.toString().trim(); // 마지막 공백 제거
    }

    //최종 우승자 메세지를 반환하는 메소드
    public static String generateWinnerMessage(String... winners) {
        return String.format(WINNER_FORMAT,
                String.join(WINNER_SEPARATOR, winners)).trim();
    }
}
