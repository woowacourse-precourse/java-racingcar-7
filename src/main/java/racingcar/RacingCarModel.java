package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringTokenizer;
import racingcar.raceDto.RacingRequest;
import racingcar.raceDto.RacingResponse;

public class RacingCarModel {

    static StringBuilder sb;

    public RacingResponse startRace(RacingRequest request) {
        /* 객체 판단 */
        if(!validateRacingObject(request)) {
            throw new IllegalArgumentException("객체값이 없습니다.");
        }
        /* 이름 판단 */
        if(!validateRacingNames(request)) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        /* 시도횟수 판단 */
        if(!validateRacingTimes(request)) {
            throw new IllegalArgumentException("시도횟수를 입력해주세요.");
        }
        sb = new StringBuilder();
        /* 이름, 게임횟수 초기화 */
        String name = request.name();
        int loop = request.times();
        /* 이름 저장 */
        ArrayList<String> nameList = new ArrayList<>();
        getName(nameList, name);
        /* 경주 시작 */
        int[] res = race(nameList, loop);
        /* 우승자 찾기 */
        int max = 0;
        for (int re : res) {
            max = Math.max(max, re);
        }
        sb.append("최종 우승자").append(" ").append(":").append(" ");

        /* 우승자 출력 */
        boolean isFirst = true;
        for(int i = 0; i < res.length; i++) {
            if(max == res[i]) {
                addComma(isFirst);
                sb.append(nameList.get(i));
                isFirst = false;
            }
        }
        /* 결괏값 반환 */
        return new RacingResponse(sb.toString());
    }

    private int[] race(ArrayList<String> list, int loop) {

        /* 몇칸 전진했는지 나타내는 배열 */
        int[] path = new int[list.size()];

        while(loop-->0) {
            /* idx == 이름 색인 */
            for(int idx = 0; idx < list.size(); idx++) {
                /* 전진 */
                forwardCar(path, idx);
                sb.append(list.get(idx)).append(" ").append(":").append(" ");
                sb.append("-".repeat(Math.max(0, path[idx])));
                sb.append("\n");
            }
            sb.append("\n");
        }

        return path;
    }

    private void addComma(boolean flag) {
        if (!flag) {
            sb.append(", ");
        }
    }

    private void forwardCar(int[] path, int idx) {
        /* 0-9 난수 생성 후 4 이상시 전진 */
        int rNum = Randoms.pickNumberInRange(0, 9);
        if(rNum >= 4) {
            path[idx]++;
        }
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

    private boolean validateRacingObject(RacingRequest request) {
        /* 객체 유무 판단 */
        return request != null;
    }

    private boolean validateRacingNames(RacingRequest request) {
        /* 이름 유무 판단 */
        return !request.name().isBlank();
    }

    private boolean validateRacingTimes(RacingRequest request) {
        /* 횟수 유무 판단 */
        return request.times() >= 0;
    }
}
