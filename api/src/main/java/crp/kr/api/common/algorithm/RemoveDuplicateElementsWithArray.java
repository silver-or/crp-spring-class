package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : RemoveDuplicateElementsWithArray
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class RemoveDuplicateElementsWithArray {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int[] arr;

        @Override
        public String toString() {
            return String.format("중복 제거 후 배열 : %s", Arrays.toString(arr));
        }
    }

    @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
    }

    @Test
    void RemoveDuplicateElementsWithArray() {
        int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
        SolutionService f = e -> {
            Set<Integer> set = new HashSet<>();
            for(int i : e.getArr()) {
                set.add(i);
            }
//            e.arr = set.toArray(Integer[]::new); // Integer 배열 사용 시
            e.arr = set.stream().mapToInt(Number::intValue).toArray();
            return e;
        };

        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
