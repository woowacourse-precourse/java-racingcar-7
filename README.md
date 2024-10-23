# java-racingcar-precourse
## 기능 목록
- 입력 값 받기
  - 게임이 진행 될 횟수
  - 각 자동차 이름 부여
- 입력 값 예외 처리
  - 잘못된 값이 들어오면 `IllegalArgumentException` 발생
  - 게임 진행 횟수 0 미만 입력 시
  - 게임 진행 횟수 정수형 이외의 타입 입력 시
- 랜덤 값을 이용한 정지 및 전진 판단 
  - 0 ~ 3의 값은 정지, 4 ~ 9의 값은 전진
  - 전진 시 이름 출력 (이 부분은 따로 메서드로 뺄까 고민 중)
- 경주 완료 후 우승자 출력
  - 1명일 시 1명의 이름만 출력
  - 2명 이상일 시 `,`를 이용하여 구분하여 출력

## 구현 시 주의 사항
- 입력 받을 때 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용할 것
- Random은 `cam.nextstep.edu.missionuntils.Randoms` 의 `pickNumberInRange()` 사용
- **다른 외부 라이브러리 절대 사용 금지**