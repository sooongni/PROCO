package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Member;

public interface MemberDao {
  List<Member> selectList(Map<String,Object> valueMap);
  int insert(Member member);
  Member selectOneByEmailPassword(Map<String,Object> valueMap);
 /* Code selectOne(int no);
  Code selectOneByEmailPassword(Map<String,Object> valueMap);
  int countAll();
  
  int delete(int no);
  int update(Code code);
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int codeNo);
  void deletePhoto(int codeNo);*/
}
