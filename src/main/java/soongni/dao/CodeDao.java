package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Code;

public interface CodeDao {
  List<Code> selectList(Map<String,Object> valueMap);
  List<Code> selectOnebyBrname(String brname);
  int insert(Code code);
 /* Code selectOne(int no);
  Code selectOneByEmailPassword(Map<String,Object> valueMap);
  int countAll();
  
  int delete(int no);
  int update(Code code);
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int codeNo);
  void deletePhoto(int codeNo);*/
 List<Code> favorClicktoCart(int postno);
int delete(int postno);
int favorUpdate(Code code);
List<Code> selectListTop5(Map<String, Object> valueMap);
List<Code> selectListbysdt(String sdt);
List<Code> selectListbyMidno(int midno);
List<Code> selectListbyType();
Code selectOnebyCode(String codeNumber);
}
