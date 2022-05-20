package crp.kr.api.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : Gugudan
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class Gugudan { // 완전탐색
    @FunctionalInterface interface SolutionService {
        void solution();
    }

    @Test
    void testGugudan() {
        SolutionService f = () -> {
            for(int k = 2; k < 10; k += 4) {
                for (int i = 1; i < 10; i++) {
                    for (int j = k; j < k + 4; j++) {
                        System.out.print(j + "*" + i+ "=" +(j * i)+"\t");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        };
        f.solution();
    }
}
