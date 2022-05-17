package crp.kr.api.common.lambdas;

/**
 * packageName: crp.kr.api.common.lambda
 * fileName   : MyLambda
 * author     : 최은아
 * date       : 2022-05-13
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-13    최은아       최초 생성
 */
public class MyLambda {
    @FunctionalInterface interface MyFunction { int apply(int a, int b); } // 사용자 정의 함수형 인터페이스 (람다)
    @FunctionalInterface interface MyConsumer { void accept(int a); }
    @FunctionalInterface interface MySupplier { int get(); }
    @FunctionalInterface interface MyPredicate { boolean test(String arg); }
    @FunctionalInterface interface MyInterface { String myMethod(); }
    @FunctionalInterface interface MyUnaryOp { int operator(Integer a); }
    @FunctionalInterface interface LengthOfString { int execute(String arg); }
    @FunctionalInterface interface MathOperation { String execute(int a, int b); }
}
