package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : MaxMin
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class MaxMin { // 그리디
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int[] arr;
        private int max, min; // 속성 → 빌더

        @Override
        public String toString() {
            return String.format("min = %d, max = %d", min, max);
        }
    }

    @FunctionalInterface private interface SolutionService {
        public Solution solution(Solution s);
    }

    @Test
    void testSolution() {
        int[] arr = {3, 1, 9, 5, 10}; // 더미
        SolutionService f = e -> {
            int min = 10, max = 0;
            for (int i : e.getArr()) {
                if (i < min) min = i;
                if (i > max) max = i;
            }
            return Solution.builder().min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
