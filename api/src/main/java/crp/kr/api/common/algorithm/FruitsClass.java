package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : FruitsClass
 * author     : 최은아
 * date       : 2022-05-18
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-18    최은아       최초 생성
 */
public class FruitsClass {
    @Builder @NoArgsConstructor @AllArgsConstructor @Getter
    public static class Solution {
        private int total, apple, grape, orange;

        @Override public String toString() {
            return String.format("total : %d, apple : %d, grape : %d, orange : %d", total, apple, grape, orange);
        }
    }

    @FunctionalInterface interface ISolution { Solution solution(Solution s); }

    @Test void solutionTest() {

    }
}
