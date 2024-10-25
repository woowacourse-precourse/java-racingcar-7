package racingcar;

public class RacingCarResultUtil {
    public static String generateIntermediateResult(int playerCount, String ... args) {
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
}
