package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import racingcar.raceDto.RacingRequest;
import racingcar.raceDto.RacingResponse;

public class RacingCarModel {

    static StringBuilder sb;

    public RacingResponse startRace(RacingRequest request) {
        /* validate logic */
        validation(request);
        /* init */
        ArrayList<String> nameList = new ArrayList<>();
        Map<String, Object> initResult = init(request, nameList);
        String name = (String) initResult.get("name");
        int loop = (Integer) initResult.get("loop");

        /* 경주 시작 */
        int[] res = race(nameList, loop);
        /* 우승자 찾기 */
        findChampion(res, nameList);
        return new RacingResponse(sb.toString());
    }

    private Map<String, Object> init(RacingRequest request, ArrayList<String> nameList) {

        sb = new StringBuilder();
        /* 이름, 게임횟수 초기화 */
        String name = request.name();
        int loop = request.times();
        /* hash 초기화 및 반환 */
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("loop", loop);

        /* 이름 저장 */
        getName(nameList, name);

        return map;
    }

    private void findChampion(int[] res, ArrayList<String> nameList) {
        /* 우승자 찾기 */
        int max = 0;
        for (int re : res) {
            max = Math.max(max, re);
        }
        sb.append("최종 우승자").append(" ").append(":").append(" ");

        /* 우승자 출력 */
        boolean isFirst = true;
        for (int i = 0; i < res.length; i++) {
            if (max == res[i]) {
                addComma(isFirst);
                sb.append(nameList.get(i));
                isFirst = false;
            }
        }
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

        validateName(s);

        for(String v : list) {
            validateNameLength(v);
        }
    }

    private void validation(RacingRequest request) {
        validateRacingObject(request);
        validateRacingTimes(request);
    }

    private void validateNameLength(String name) {
        /* 이름길이가 5이하 인지 판단 */
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("유저의 이름은 5글자를 넘길 수 없으며, 빈 값일 수 없습니다.");
        }
    }

    private void validateName(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }
    }

    private void validateRacingObject(RacingRequest request) {
        /* 객체 유무 판단 */
        if(request == null) throw new IllegalArgumentException("객체가 없습니다.");
    }

    private void validateRacingTimes(RacingRequest request) {
        /* 횟수 유무 판단 */
        if(request.times() < 0) throw new IllegalArgumentException("횟수는 음수를 입력할 수 없습니다.");
    }
}
