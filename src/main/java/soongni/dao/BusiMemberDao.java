package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.BusiMember;

public interface BusiMemberDao {
  List<BusiMember> selectList(Map<String,Object> valueMap);
  int insert (BusiMember busiMember);
  BusiMember brandMemberBrand(int ceono);
 /* Code selectOne(int no);
  Code selectOneByEmailPassword(Map<String,Object> valueMap);
  int countAll();
  
  int delete(int no);
  int update(Code code);
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int codeNo);
  void deletePhoto(int codeNo);*/
}
