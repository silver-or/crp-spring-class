package crp.kr.api.common.lambdas;

import org.junit.jupiter.api.Test;

import static crp.kr.api.common.dataStructure.AppleList.Apple;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.function.*;

/**
 * packageName: crp.kr.api.common.lambda
 * fileName   : LambdaUtil
 * author     : 최은아
 * date       : 2022-05-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-11    최은아       최초 생성
 */
public class Lambda {
    @Test
    void lambdaTest() {
//        System.out.println(Lambda.integer("900"));
        System.out.println(Lambda.string(900));
        System.out.println(string(new Apple.Builder().origin("영동").color("RED").price(3000).build()));
        System.out.println(string(
                Arrays.asList(
                    new Apple.Builder().origin("영동").color("RED").price(3000).build(),
                    new Apple.Builder().origin("영동").color("BLUE").price(3000).build(),
                    new Apple.Builder().origin("풍기").color("BLUE").price(3000).build()
                )
        ));
        System.out.println(equals("홍길동", "홍"));
        System.out.println(equals("홍길동", "홍길동"));
        System.out.println(array(8).length);
        System.out.println(random(1, 9));
//        System.out.println(makeFile("C:\\Users\\admin\\Documents\\KDT5\\new").mkdir());
    }

    public static int integer(String arg) {
//        Integer i = Integer.parseInt("900")
        Function<String, Integer> f = Integer::parseInt; // <파라미터타입, 리턴타입> // :: 메소드 참조
        return f.apply(arg);
    }

    public static long longParse(String s) {
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }

    public static float floatParse(String s) {
        Function<String, Float> f = Float::parseFloat;
        return f.apply(s);
    }

    public static String string(Object o) {
//        String s = String.valueOf(o); // JSON.stringify()
        Function<Object, String> f = String::valueOf; // f : 함수형 객체 = 람다 (고유값 -> 단 하나),  String::valueOf -> 람다를 만들어내는 람다식
        return f.apply(o);
        // 레거시 : new 없음 -> 객체가 아닌데 객체의 일을 함 -> f.apply(o)
        // 모던 : functional interface
    }

    public static boolean equals(String s1, String s2) {
//        boolean b = "홍길동".equals("홍%");
        BiPredicate<String, String> p = String::equals; // Predicate은 이미 리턴타입이 boolean으로 fix
        return p.test(s1, s2);
    }

//    int[] arr = new int[8];
//    int 타입의 size를 파라미터로 던지면 arr가 생성됨
    public static int[] array(Integer i) {
        Function<Integer, int[]> f = int[]::new;
        return f.apply(i);
    }

    public static int random(Integer min, Integer max) {
//        BiFunction<Integer, Integer, Integer> f = Math::random * max + min; // 메소드 참조는 파라미터 사용 불가 -> 메소드 참조 우선, 안 되면 람다로 처리
        BiFunction<Integer, Integer, Integer> f = (t, u) -> (int)(Math.random() * u) + t; // area (state) -> 이벤트 발생 시에만
        return f.apply(min, max);
    }

    public static File makeFile(String arg) {
        Function<String, File> f = File::new;
        return f.apply(arg);
    }

    public static String getDateToString() {
        Supplier<String> s = () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return s.get();
    }

    public static Date getDate() {
        Supplier<Date> s = Date::new;
        return s.get();
    }
}
