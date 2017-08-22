package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Code;

public interface CodeDao {
	List<Code> selectList(int mno);
	List<Code> selectOnebyBrname(String brname);
	int insert(Code code);
	List<Code> favorClicktoCart(int postno);
	int delete(int postno);
	int favorUpdate(Code code);
	List<Code> selectListTop5(Map<String, Object> valueMap);
	List<Code> selectListbysdt(String sdt);
	List<Code> selectListbyMidno(int midno);
	List<Code> selectListbyType();
	Code selectOnebyCode(String codeNumber);
}
