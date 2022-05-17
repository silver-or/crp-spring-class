package crp.kr.api.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : CheckSameArray
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class CheckSameArray { // p. 40 연습문제 02_3
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
//        private List<Integer> arr1, arr2;
        private int[] arr1, arr2;
        private String res;

        @Override
        public String toString() {
            return String.format("A배열 %s와 B배열 %s은(는) %s 배열입니다.", Arrays.toString(arr1), Arrays.toString(arr2), res);
//            return String.format("A배열 %s, B배열 %s은(는) %s 배열입니다.", arr1, arr2, res);
        }
    }

    @FunctionalInterface interface SolutionService {
        public Solution solution(Solution s);
    }

    @Test
    void testCheckSameArray() {
        SolutionService f = e -> {
            int cnt = 0;
            for (int i : e.getArr1()) {
                for (int j : e.getArr2()) {
                    if (i == j) {
                        cnt++;
                        break;
                    }
                }
            }
            e.res = cnt == e.arr1.length ? "같은" : "다른";
            return e;
        };
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {2, 3, 1};
//        Solution s = Solution.builder().arr1(Arrays.asList(1, 3, 2)).arr2(Arrays.asList(2, 3, 2)).build();
        Solution s = Solution.builder().arr1(arr1).arr2(arr2).build();
        System.out.println(f.solution(s));
    }
}
