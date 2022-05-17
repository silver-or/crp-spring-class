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
public class Gugudan {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int start, end;
        @Override
        public String toString() {
            return super.toString();
        }
    }
    @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
    }

    @Test
    void testGugudan() {

    }
}
