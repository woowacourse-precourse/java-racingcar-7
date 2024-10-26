# java-racingcar-precourse


## 입력 처리
- 기능
  - 경주할 자동차 이름 입력(쉼표로 구분)
  - 시도할 횟수 입력
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
  - 잘못된 값을 입력할 경우, `IllegalArgumentException` 발생시킨 후 애플리케이션 종료
- 유효성 검사
  - 경주할 자동차 이름: 빈 값이나 공백이 아닌 5자 이하의 문자열
  - 시도할 횟수: 양의 정수


## 로직 구현
- 0 ~ 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상인 경우에 전진
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용
- 차수별 실행 결과 


## 출력 처리
- 차수별 실행 결과 프린트 
  ````
  pobi : --  
  woni : ----
  jun : ---
  ````  

- 우승자 안내 문구 출력
  - 단독: `최종 우승자 : pobi`
  - 공동: `최종 우승자 : pobi, jun`


## 테스트
- 입력 처리
  - 자동차 이름
  - 시도할 횟수
- 로직
  - 4 이상이 경우 전진
  - 4 미만인 경우 멈춤
- 출력 처리
  - 차수별 실행 결과 프린트 
  - 우승자 안내 문구 단독인 경우, 공동인 경우