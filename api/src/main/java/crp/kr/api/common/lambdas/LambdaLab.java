package crp.kr.api.common.lambdas;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.Supplier;

import static crp.kr.api.common.lambdas.Lambda.*;

/**
 * packageName: crp.kr.api.common.lambdas
 * fileName   : LambdaLab
 * author     : 최은아
 * date       : 2022-05-26
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-26    최은아       최초 생성
 */
public class LambdaLab {
    public static void solution() {

    }

    @Test
    public void testSolution() {
        System.out.println(string(getDate()));
        System.out.println(getDateToString());
    }
}
