package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringTokenizer;
import racingcar.raceDto.RacingRequest;

public class RacingCarModel {

    static StringBuilder sb;

    public void startRace(RacingRequest request) {
        /* 객체, 이름, 숫자 존재여부 판단 */
        if(!validateRacingInfo(request)) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }
        /* sb, 이름, 게임횟수 초기화 */
        sb = new StringBuilder();
        String name = request.name();
        int loop = request.times();

        ArrayList<String> nameList = new ArrayList<>();
        getName(nameList, name);

        int[] res = race(nameList, loop);
        int max = 0;
        /* 우승자 찾기 */
        for (int re : res) {
            max = Math.max(max, re);
        }
        sb.append("최종 우승자").append(" ").append(":").append(" ");

        /* 우승자 출력 */
        boolean isFirst = true;
        for(int i = 0; i < res.length; i++) {
            if(max == res[i]) {
                if (!isFirst) {
                    sb.append(", ");
                }
                sb.append(nameList.get(i));
                isFirst = false;
            }
        }


        System.out.println(sb);
    }

    private int[] race(ArrayList<String> list, int loop) {

        /* 몇칸 전진했는지 나타내는 배열 */
        int[] path = new int[list.size()];

        while(loop-->0) {
            /* idx == 이름 색인 */
            for(int idx = 0; idx < list.size(); idx++) {
                /* 0-9 난수 생성 후 4 이상시 전진 */
                int rNum = Randoms.pickNumberInRange(0, 9);
                if(rNum >= 4) {
                    path[idx]++;
                }

                sb.append(list.get(idx)).append(" ").append(":").append(" ");
                sb.append("-".repeat(Math.max(0, path[idx])));
                sb.append("\n");
            }
            sb.append("\n");
        }

        return path;
    }

    private void getName(ArrayList<String> list, String s) {

        StringTokenizer st = new StringTokenizer(s, ",");
        while(st.hasMoreTokens()) {
            String cur = st.nextToken();
            list.add(cur);
        }

        for(String v : list) {
            if(!validateNameLength(v)) {
                throw new IllegalArgumentException("이름길이 5이하로 작성해주세요.");
            }
        }
    }

    private boolean validateNameLength(String name) {
        /* 이름길이가 5이하 인지 판단 */
        return name.length() <= 5;
    }

    private boolean validateRacingInfo(RacingRequest request) {
        /* 객체, 이름, 숫자 존재여부 판단 */
        return request != null && !request.name().isEmpty() && request.times() != 0;
    }
}
