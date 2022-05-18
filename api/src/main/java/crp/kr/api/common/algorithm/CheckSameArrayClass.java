package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : CheckSameArrayClass
 * author     : 최은아
 * date       : 2022-05-18
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-18    최은아       최초 생성
 */
public class CheckSameArrayClass {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int[] arr1, arr2;
        private String result;

        @Override public String toString() { return String.format("A배열, B배열은 %s 배열입니다.", result); }
    }

    @FunctionalInterface interface ISolution { Solution solution(Solution s); }

    @Test
    void testCheckSameArray() {
    }
}
