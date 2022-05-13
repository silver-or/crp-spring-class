package crp.kr.api.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName   : BmiList
 * author     : 최은아
 * date       : 2022-05-11
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-11    최은아       최초 생성
 */
public class BmiList {
    @Data @NoArgsConstructor
    static class Bmi {
        private double height, weight;
        private String ssn;

        public Bmi (Builder builder) {
            this.ssn = builder.ssn;
            this.height = builder.height;
            this.weight = builder.weight;
        }

        @NoArgsConstructor static class Builder {
            private double height, weight;
            private String ssn;
            public Builder(String ssn) { this.ssn = ssn; }
            public Builder height(double height) { this.height = height; return this; }
            public Builder weight(double weight) { this.weight = weight; return this; }
            Bmi build() { return new Bmi(this); }
        }
    }

    @Test
    void bmiAppTest() {
        BmiService service = new BmiServiceImpl();
        System.out.println("### 1. save ###");
        Bmi p1 = new Bmi.Builder("000817-4")
                .height(163.6)
                .weight(51)
                .build();
        service.save(p1);
        System.out.println("### 6. findAll\n" + service.findAll());
    }

    interface BmiService {
        void save(Bmi bmi);
        void update(int i, Bmi bmi);
        void delete(Bmi bmi);
        List<Bmi> findByGender(String gender);
        Bmi findById(int i);
        List<Bmi> findAll();
        int count();
    }

    static class BmiServiceImpl implements BmiService {
        private final List<Bmi> list;
        public BmiServiceImpl() {
            list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {
            list.add(bmi);
        }

        @Override
        public void update(int i, Bmi bmi) {
            list.set(i, bmi);
        }

        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public int count() {
            return list.size();
        }
    }
}
