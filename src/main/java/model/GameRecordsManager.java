package model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class GameRecordsManager {
  public Map<String, String> carGameRecords = new HashMap<>();

  public void createCarGameRecords(List<String> cars) {

    // 차 이름이 5자를 초과하는지 검증
    for (String carName : cars) {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("차 이름이 5자를 초과했습니다: " + carName);
      }
      this.carGameRecords.put(carName, "");  // 초기 값은 빈 문자열_전진을 안했으니까
    }
  }
}
