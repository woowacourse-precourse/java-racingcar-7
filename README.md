# 우아한 테크코스 프리코스 2주차
# 자동차 경주

1. **자동차 이름 입력 처리 기능 구현**
   - **설명:** 사용자가 입력한 자동차 이름을 쉼표(,)로 구분하여 처리하고, 이름의 길이를 검증합니다.

2. **시도 횟수 입력 처리 기능 구현**
   - **설명:** 사용자가 입력한 시도 횟수를 처리하고 유효성을 검증합니다.

3. **자동차 클래스 생성**
   - **설명:** 자동차의 이름과 전진 여부를 관리하는 `Car` 클래스를 생성합니다.

4. **전진 조건 로직 구현**
   - **설명:** 0에서 9 사이의 무작위 값을 생성하고, 값이 4 이상일 경우 자동차가 전진하도록 로직을 구현합니다.

5. **경주 실행 로직 구현**
   - **설명:** 주어진 시도 횟수 동안 모든 자동차의 전진 여부를 결정하고 결과를 기록합니다.

6. **경주 결과 출력 기능 구현**
   - **설명:** 각 차수별로 자동차의 전진 결과를 출력합니다.

7. **우승자 결정 및 출력 기능 구현**
   - **설명:** 경주가 완료된 후, 우승자를 결정하고 단독 또는 공동 우승자를 출력합니다.

8. **공동 우승자 처리 로직 추가**
    - **설명:** 우승자가 여러 명일 경우, 쉼표(,)로 구분하여 출력하도록 로직을 추가합니다.

9. **입력 값 예외 처리 구현**
    - **설명:** 잘못된 입력 값이 들어올 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료하도록 처리합니다.

10. **JUnit 5 및 AssertJ를 이용한 유닛 테스트 작성**
    - **설명:** 각 기능별로 유닛 테스트를 작성하여 코드의 정상 동작을 검증합니다.

11. **코드 리팩토링 및 인덴트 깊이 조정**
    - **설명:** 코드의 인덴트 깊이를 2로 유지하며, 메서드를 분리하여 코드 가독성을 높입니다.

12. **자바 코드 컨벤션 준수 및 최종 점검**
    - **설명:** 전체 코드를 자바 코드 컨벤션에 맞게 수정하고, 최종적으로 요구 사항을 모두 충족하는지 점검합니다.

1. **프로젝트 빌드**
   ```bash
   ./gradlew build
