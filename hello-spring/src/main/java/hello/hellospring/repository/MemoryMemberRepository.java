package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Map; //Map 임포트 꼭 해주기!!-> Map은 키와 값의 쌍으로 이루어진 데이터를 저장하는 자료구조
import java.util.ArrayList;
import java.util.HashMap; //Map은 인터페이스이므로 직접 인스턴스를 생성할 수 없으니까 HashMap과 같은 구현 클래스를 임포트 해줌!
import java.util.Optional;
import java.util.List;
@Repository
public class MemoryMemberRepository implements MemberRepository{

    public static Map<Long,Member> store = new HashMap<>(); // 저장(save)을 하기 위해서 Map을 사용
    private static long sequence = 0L; // sequece는 0,1,2같은 키 값을 생성해주는 친구임
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // sequence 값을 하나 올려줌
        store.put(member.getId(), member); // 저장을 해줌 -> Map에 저장이 된다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store에서 아이디를 꺼내줌 -> null값이 있는 경우를 대비해 ptional으로 감싸줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //루프를 돌림
                .filter(member -> member.getName().equals(name)) //member.getName()이 파라미터에서 넘어온 name과 같은지 확인
                .findAny(); //같은 경우에만 필터링이 되고 찾으면 반환함-> 하나라도 찾으면 반환
    }
    @Override
    public List<Member> findAll() { //Map을 사용하지만 반환은 list로 되어있음 -> 자바에서는 list를 많이 씀
        return new ArrayList<>(store.values()); //store에 있는 values가 Member들이니까 멤버를 반환함.
    }

    public void clearStore(){
        store.clear(); //store을 싹 지움
    }
}
