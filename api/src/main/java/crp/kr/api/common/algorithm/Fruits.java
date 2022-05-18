package crp.kr.api.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : Fruits
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class Fruits {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int total, apple, grape, orange;
        private int[][] fruitMarket;

        @Override
        public String toString() {
            return String.format("총합 : %d\n사과 평균 : %d\n포도 평균 : %d\n오렌지 평균 : %d\n",
                    total, apple / fruitMarket.length, grape / fruitMarket.length, orange / fruitMarket.length);
        }
    }

     @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
     }

    @Test
    void testFruit() {
         int[][] fm = new int[][]{
                 {10000, 20000, 12000},
                 {8000, 3000, 15000},
                 {20000, 15000, 38000},
                 {13000, 20000, 30000},
                 {30000, 12000, 20000},
                 {35000, 30000, 25000},
                 {50000, 23000, 10000}
         };

         SolutionService f = e -> {
            for (int[] ints : e.fruitMarket) {
                for (int j = 0; j < ints.length; j++) {
                     if (j == 0) e.apple += ints[j];
                     else if (j == 1) e.grape += ints[j];
                     else e.orange += ints[j];
                     e.total += ints[j];
                }
            }
            return e;
         };

         Solution s = Solution.builder().fruitMarket(fm).build();
         System.out.println(f.solution(s));
     }
}
