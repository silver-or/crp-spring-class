package crp.kr.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import crp.kr.api.user.domains.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/*
    스프링에서 생성자는 4개
    @Controller 라우터
    @Service 미들웨어
    @Repository 커넥터 (DB 접속)
    @Component 순수 자바 객체

    <서버> ex. 스프링, 장고, 플라스크, 닷넷 프레임워크
    라우터 - 미들웨어 - 커넥터

    <언어> ex. 자바, 파이썬, C++, C#, 자바스크립트
    (순수)     자바 : 컴포넌트 -> POJO
*/
@Component // 생성자 -> Vector vector = new Component();
@Data // getter, setter
@Lazy // DB 구조 필요없을 때 사용
public class Box<K, V> {
    private HashMap<K, V> map;

    public Box(){
        this.map = new HashMap<>();
    }

    public void put(K k, V v) {
        map.put(k, v);
    }

    public void replace(K k, V v) {
        map.replace(k, v);
    }

    public void remove(K k, V v) {
        map.remove(k, v);
    }

    public V get(String id) {
        return map.get(id);
    }

    public List<V> values() {
        return new ArrayList<>(map.values());
    }

    public int size() {
        return map.size();
    }

    public boolean containsKey(Object k) {
        return map.containsKey(k);
    }

    public void clear() { map.clear();}

    // User custom
    // 테이블 행 목록 요청 시
    public List<V> findAllList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V)e.getValue());
        }
        return ls;
    }

    // 테이블 키값 목록 요청 시
    public List<V> findAllKeyList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V)e.getValue());
        }
        return ls;
    }

    // 이름으로 검색된 회원 목록 요청 시 (필터가 필요없이 리액트로 던지는 경우)
    public List<User> findByUserName(String name) { // return List -> 리액트에 보내기 직전
        List<User> ls = new ArrayList<>();
        for (User v : ls) {  if (name.equals(v.getName())) ls.add(v); }
        return ls;
    }

    // 이름으로 검색된 회원 목록 요청 시 (추가 필터를 통해 더 줄어든 결괏값이 필요한 경우) -> Map의 검색 속도가 더 빠름
    public Map<String, User> mapFindByUserName(String name){
        Map<String, User> map = new HashMap<>();
        for (Map.Entry<String, User> e : map.entrySet()) { // entry : map의 element (안에 들어있는 요소값)
            if (name.equals(e.getValue().getName())) map.put(e.getKey(), e.getValue());
        }
        return map;
    }
}
