package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName   : PrimeNumber
 * author     : 최은아
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-17    최은아       최초 생성
 */
public class PrimeNumber {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int start, end;
        List<Integer> primes;

        @Override
        public String toString() {
            return String.format("%d와 %d 사이 소수 : %s", start, end, primes);
        }
    }

    @FunctionalInterface interface SolutionService {
        public Solution solution(Solution s); // 리턴타입과 파라미터는 무조건 Solution
    }

    @Test
    void testPrime() {
        SolutionService f = e -> {
            Solution s = Solution.builder().start(e.start).end(e.end).primes(e.primes).build();
            for (int i = s.start; i <= s.end; i++) {
                boolean isPrimeNumber = true;
                if (i == 1) continue;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                if (isPrimeNumber) { s.primes.add(i); }
            }
            return s;
        };
        Solution s = Solution.builder().start(1).end(100).primes(new ArrayList<>()).build();
        System.out.println(f.solution(s));
    }
}
