# java-racingcar-precourse

### 🏁 기능 목록

#### - 자동차 등록
 - [X] 경주에 참가할 자동차 이름 입력 안내문구 출력
 - [X] 경주에 참가할 자동차 이름 입력(String)
 - [X] 쉼표로 이름 구분
 - [X] 공백 제거
 - [X] 이름 5자 이하 검증
#### - 게임
  - [x] 시도할 횟수 입력(Integer 형 변환 필요)
  - [X] 0~9사이 무작위 값 생성
  - [X] 생성된 무작위 값 4이상인지 아닌지 판단
  - [X] 시도할 횟수 만큼 반복
  - [X] 자동차 마다 시도횟수마다 결과 넣을 목록 구현 (Hash Map)
    - [X] 자동차 결과 DTO 구현
    - [X] 자동자 DTO 생성
    - [X] 한 횟수 종료시 move 결과 list 생성
    - [X] 결과 Map <시도횟수 , DTO List> put
  - [X] 4이상이면 전진 아니면 제자리(4 이상이면 - add, 아니면 아무것도 하지 않음)
  - [X] 최종 우승자 판단
  - [X] 실행 결과 출력
    - [X] 참가한 자동차 1세트 종료 후 \n -> 다음 세트 결과 출력

#### - 게임 종료
  - [X] 결과 조회 후, 전진을 가장 많이 한 자동차 찾기
  - [X] 최종 우승자 문자열 출력(우승자 여러명이면 , 이용해서 문자열 생성)
#### - 예외
  - [X] 이름 5자 이하가 아니면 IllegalArgumentException
  - [X] 이름이 공백이면
  - [X] 시도할 횟수 검증(문자 , 공백, null)