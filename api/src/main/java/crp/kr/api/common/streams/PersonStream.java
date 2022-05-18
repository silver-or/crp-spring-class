package crp.kr.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.streams
 * fileName   : PersonStream
 * author     : 최은아
 * date       : 2022-05-16
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-16    최은아       최초 생성
 */
public class PersonStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Person { // static = const // 바깥에 root class가 있을 경우
        private String name, ssn;

        @Override public String toString() {
            int genderChk = Integer.parseInt(ssn.substring(ssn.length()-1));
            String gender = genderChk % 2 == 1 ? "남성" : "여성";
            int birthYear = Integer.parseInt(ssn.substring(0, 2));
            birthYear += genderChk < 3 ? 1900 : 2000;
            int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear + 1; // 1의 의미는 한국 나이로 태어나면 1살부터 시작
            return String.format("%s님은 %s세 %s입니다.", name, age, gender);
        }
    }

    @FunctionalInterface interface PersonService { // @FunctionalInterface 로 구분
        Person search(List<Person> arr, String name); // 메소드 단 하나 존재
    }

    @Test
    void personStreamTest() {
        List<Person> ls = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );
        PersonService ps = (arr, name) -> arr // 타입 추론 (위에서) → List<Person> arr, String name
                .stream()
                .filter(e -> e.getName().equals(name)) // stream 위에 떠다니는 person 객체 -> 다른 타입(List<>, Set<>, Map<>) 으로 변경 가능 // e : element (집합체 안의 요소 하나)
                // 이름이 name인 객체를 필터링해서 다 모음
                .collect(Collectors.toList()).get(0); // 하나의 리스트 (stream) 안에서 움직임 -> 0번째 리턴
        System.out.println(ps.search(ls, "유관순"));

    }
}