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
        private int[] arr1, arr2;
        private String res;

        @Override public String toString() { return String.format("A배열, B배열은 %s 배열입니다.", res); }
    }

    @FunctionalInterface interface SolutionService { Solution solution(Solution s); }

    @Test
    void testCheckSameArray() {
        SolutionService f = e -> {
            Arrays.sort(e.getArr1());
            Arrays.sort(e.getArr2());
            e.res = Arrays.equals(e.arr1, e.arr2) ? "같은" : "다른";
            return e;
        };

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 3, 1};
        Solution s = Solution.builder().arr1(arr1).arr2(arr2).build();
        System.out.println(f.solution(s));
    }
}
