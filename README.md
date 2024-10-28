# java-racingcar-precourse

1. 사용자 입력을 받는 ConsoleInputHandler 클래스
   - 플레이어의 이름을 입력 받음
   - 총 이동 횟수 입력 받음
   - 검증기를 이용해서 입력을 검증

2. 경주 진행을 위한 안내문을 출력하는 ConsoleOutputHandler 클래스
   - 각종 안내문 출력
   - 매 스테이지 후 경주 상태 출력
   - 최종 우승자 출력

3. 입력 검증기 Validator
   - 이름의 길이가 5 이상이면 IllegalArgumentException 발생
   - 0 이상 9 이하가 아니면 IllegalArgumentException 발생

4. 실제 경주를 진행하는 Racing 클래스
   - 매 스테이지 마다 플레이어는 랜덤 숫자를 하나 생성
   - 랜덤 숫자가 0 이상 9 이하면 플레이어 이동
   - 1등의 이동 거리를 기록
   - 경기 종료 후 승자 판정

5. 플레이어를 나타내는 Player 클래스
   - 플레이어가 움직이면 이동거리가 1 증가

6. 특정 플레이어의 이동 경로를 알려주는 RacingSnapshotProvider 클래스
   - 플레이어의 이동 거리를 이용해 지금까지의 이동 경로를 제공

7. Application 클래스
   - 자동차 경주 애플리케이션의 진입점
