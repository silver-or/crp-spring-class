package crp.kr.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName   : Box
 * author     : 최은아
 * date       : 2022-05-12
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-12    최은아       최초 생성
 */
@Component // 순수 자바 객체
@Data @Lazy // Lazy Loading -> 호출할 때 인스턴스 생성 -> DB가 필요없음 (임시 저장) -> 구동 속도 ↑
public class Vector<T> { // 무슨 타입이든 간에 넣으면 해당 타입이 됨
    private ArrayList<T> list;

    public Vector(){
        this.list = new ArrayList<>();
    }

    // save, update, delete, findAll, findByName, findById, count, existsById, clear
    // add, set, remove, get(), X, get(i), size, X, clear

    public void add(T t) {
//        Consumer<T> c = list::add;
//        c.accept(t);
        list.add(t);
    }

    public void set(int i, T t) {
//        BiConsumer<Integer, T> c = list::set;
//        c.accept(i, t);
        list.set(i, t);
    }
    public void remove(T t) {
//        Consumer<T> c = list::remove;
//        c.accept(t);
        list.remove(t);
    }

    public ArrayList<T> get() {
//        Supplier<Object[]> s = list::toArray;
//        return s.get();
        return list;
    }

    public T get(int i) {
//        Function<Integer, T> f = list::get;
//        return f.apply(i);
        return list.get(i);
    }

    public int size() {
//        Supplier<Integer> s = list::size;
//        return s.get();
        return list.size();
    }

    public void clear() {
//        Runnable r = list::clear;
//        r.run();
        list.clear();
    }
}
