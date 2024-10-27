package validators;

import java.util.List;
import java.util.Set;

public class RoundsValidator {

    private static final int Empty = 0;

    // 횟수 입력 값이 0이거나 0보다 작을 때 오류 메세지 터트리기
    public static void countValidate(List<Integer> counts) {
        for (Integer count : counts) {
            if (count == Empty || count <= Empty) {
                throw new IllegalArgumentException("횟수는 0 이상이어야 합니다.");
            }
        }
    }
}
