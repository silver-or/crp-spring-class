package crp.kr.api.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : RemoveDuplicateElements
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class RemoveDuplicateElementsWithList {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private List<Integer> ls;

        @Override
        public String toString() {
            return String.format("중복 제거 후 배열 : %s", ls);
        }
    }
    @FunctionalInterface interface SolutionService {
        public Solution solution(Solution s);
    }

    @Test
    void RemoveDuplicateElementsWithList() {
        List<Integer> ls = Arrays.asList(5, 10, 9, 27, 2, 8, 10, 4, 27, 1);
        SolutionService f = e -> {
            e.ls = e.ls.stream().distinct().collect(Collectors.toList());
            return e;
        };

        Solution s = Solution.builder().ls(ls).build();
        System.out.println(f.solution(s));
    }
}
