package crp.kr.api.common.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName   : Trunk
 * author     : 최은아
 * date       : 2022-05-12
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-12    최은아       최초 생성
 */
public class Trunk<K, V> {
    private HashMap<K, V> hashMap;

    public Trunk(){
        this.hashMap = new HashMap<>();
    }

    public void put(K k, V v) {
        hashMap.put(k, v);
    }

    public void replace(K k, V v) {
        hashMap.replace(k, v);
    }

    public void remove(Object k) {
        hashMap.remove(k);
    }

    public V findById(String id) {
        return hashMap.get(id);
    }

    public List<V> findByName(String name) {
        List<V> list = new ArrayList<>();
        return list;
    }

    public List<V> findAll() {
        return hashMap.values().stream().collect(Collectors.toList());
    }

    public int count() {
        return hashMap.size();
    }

    public boolean existsById(String id) {
        return hashMap.containsKey(id);
    }

}
