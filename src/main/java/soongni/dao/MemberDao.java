package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Member;

public interface MemberDao {
	List<Member> selectList(Map<String,Object> valueMap);
	Member passwordCheck(Map<String, Object> valueMap);
	Member selectOneByEmailPassword(Map<String,Object> valueMap);
	int insert(Member member);
	int update(Member member);
	int delete(int mno);
	void photoupload(Member member);
	Member selectOne(int mno);
}
