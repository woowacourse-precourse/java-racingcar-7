#### 2024-10-27

##### Documentation Changes

*  update README.md (e554e0ee)
*  update CHANGELOG.md (73df022f)
*  create CHANGELOG.md (20ef3336)
*  update README.md (71029c46)

##### New Features

*  메인 애플리케이션 클래스 구현 (62b4abb2)
*  사용자 입력을 받아, Service와 연결할 Controller 클래스 구현 (80e3d4cf)
*  각 라운드별 현재 상태 출력 및 최종 우승자 출력 View 클래스 구현 (558a217a)
*  우승자 선별 메서드 구현 (e6921c16)
*  랜덤 숫자 기반 차량 전진 메서드 구현 (5ed08a84)
*  차량 생성 메서드 구현 (7b663a13)
*  사용자의 입력을 받는 InputView 구현 (b7c82c4c)
*  우승 상태 판단을 위한 Enum 구현 (e39edd73)
*  Car 엔티티 구현 (caf56d72)
*  setup project (5ec13447)

##### Bug Fixes

*  입력받은 라운드 수가 1보다 작을 때 예외처리 (eb2dc164)
*  goForward 메서드 접근 제어자 수정 (b99bdab1)

##### Refactors

*  service가 인터페이스에 의존하도록 수정 (7140db66)
*  random number generator 클래스와 인터페이스 생성 (8bc33ccc)
*  기존 For문 Stream 구문으로 변경 (8307cbb9)
*  createCars 메서드 리팩터링 (6bcc76a3)
*  moveCars 메서드 리팩터링 (05f0e172)
*  불필요한 enum 타입 삭제 (c46b9aa6)

##### Code Style Changes

*  NumberGenerator 인터페이스 패키지 변경 (e99f0aeb)
*  Stream구문 포맷팅 (01e665a9)
*  Intellij IDEA 자동 포맷팅 (9cb11412)

##### Tests

*  차량 전진, 차량 정지 메서드 테스트 코드 구현 (395e1611)
*  CarService 클래스 테스트 코드 구현 (e2e8eebf)
*  Car 엔티티 테스트 코드 작성 (2db41bb5)

