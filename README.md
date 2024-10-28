# java-racingcar-precourse

## 구현할 기능 목록
### 입출력
### 중복된 이름 검증
### 자동차 추가
### 자동차 전진 혹은 멈춤
### 자동차 이동한 거리 측정
### 우승자 판별

## 깨달은 점 & 피드백

## HashMap 의 함정..
원래 로직은 HashMap 에 Car 들을 저장하였는데 애플리케이션 테스트에서 순서가 뒤엉켜버렸다..  
제공된 라이브러리가 첫번째 Random 실행값을 4로, 두번쨰 실행값을 3으로 고정시켰기 때문에 순서와 결과가 함께 섞인 것 같다...  
-> LinkedHashMap 으로 해결하였다

### 어차피 getter 쓴다고 private final 대신 public final 썼던 것을 반성합니다..
getter 의 확장성을 싸그리 뭉개버리는 행위였던 것 같습니다..  
+) 정보 은닉 역시..

### Car 관련 정보의 변경은 무조건 Car 엔티티(루트 엔티티) 를 통해서 하기로..!

### Controller 의 역할은 사용자와 소통하는 것
지난주차에 스프링으로 프로젝트를 진행하는 것 처럼 설계하였는데 그것은 스프링 한정 Controller 였던 것 같습니다  
Controller 의 본질적인 역할을 기억해야 할 것 같습니다.. 