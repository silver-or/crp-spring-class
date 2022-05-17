package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
public class MaxMin {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MaxMinVO {
        private int num;

        @Override
        public String toString() {
            int min = 0;
            int max = 0;
            return String.format("min = %d, max = %d", min, max);
        }
    }

    interface MaxMinService {
        int getMin(List<MaxMinVO> ls);
        int getMax(List<MaxMinVO> ls);
    }

    static class MaxMinServiceImpl implements MaxMinService {

        @Override
        public int getMin(List<MaxMinVO> ls) {
            int min = ls.get(0).num;
            for (int i = 1; i < ls.size(); i++) {
                if (min > ls.get(i).num) { min = ls.get(i).num; }
            }
            return min;
        }

        @Override
        public int getMax(List<MaxMinVO> ls) {
            int max = ls.get(0).num;
            for(int i = 1; i < ls.size(); i++) {
                if (max < ls.get(i).num) { max = ls.get(i).num; }
            }
            return max;
        }
    }

    @Test
    void maxMinTest() {
        List<MaxMinVO> ls = Arrays.asList(
                MaxMinVO.builder().num(1).build(),
                MaxMinVO.builder().num(3).build(),
                MaxMinVO.builder().num(5).build(),
                MaxMinVO.builder().num(9).build(),
                MaxMinVO.builder().num(10).build()
        );
        System.out.println("최솟값 : " + new MaxMinServiceImpl().getMin(ls));
        System.out.println("최댓값 : " + new MaxMinServiceImpl().getMax(ls));
    }
}
