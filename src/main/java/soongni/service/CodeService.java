package soongni.service;

import java.util.List;

import soongni.domain.Code;

public interface CodeService {
	List<Code> list(int pageNo, int pageSize) throws Exception;
	void add(Code code) throws Exception;
	List<Code> selectOnebyBrname(String brname) throws Exception;
	List<Code> favorClicktoCart(int postno) throws Exception;
	/*Code get(int no) throws Exception;
  Code getByEmailPassword(String email, String password) throws Exception;
  int getSize() throws Exception;

  void update(Code code) throws Exception;
  void remove(int no) throws Exception;*/
	void favorUpdate(Code code)throws Exception;
	List<Code> selectListTop5(int pageNo, int pageSize) throws Exception;
	List<Code> selectListbysdt(String sdt)throws Exception;
	List<Code> selectListbyMidno(int midno)throws Exception;
	List<Code> selectListbyType()throws Exception;
	Code selectOnebyCode(String codeNumber);
}







