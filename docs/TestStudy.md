# Test 코드 정리 
자바 단위 테스트 작성에는 2가지 라이브러리가 사용된다.
- JUnit5: 자바 단위 테스트를 위한 테스팅 프레임워크
- AssertJ: 자바 테스트를 돕기 위해 다양한 문법을 지원하는 라이브러리

## given / when / then 패턴 
```java
@DisplayName("테스트 이름")
@Test

void testMethod() {
    // given 
    
    // when 
    
    // then
    
}

```
- given : 어떠한 데이터가 준비 되었을 때 
- when : 어떠한 함수를 실행하면 
- then : 어떠한 결과가 나와야 한다. 

@Test  : 해당 메소드가 단위 테스트임을 명시하는 어노테이션이다. JUint은 테스트 패키지 하위의 @Test 어노테이션이
붙은 메소드를 단위 테스트로 인식하여 실행 시킨다. 
@DisplayName("<읽기 좋은 이름>") : 작업자가 읽기 좋은 다른 이름을 부여할 수 있다.

테스트 코드는 위와 같은 형태를 흔히 작성하는데, IntelliJ의 live template를 사용하면 빠르게 작성 가능 
Live template 설정 방법 : https://velog.io/@max9106/IntelliJ-Live-Template


출처: https://mangkyu.tistory.com/144 [MangKyu's Diary:티스토리]

----

#  NsTest