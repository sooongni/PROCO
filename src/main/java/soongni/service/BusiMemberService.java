package soongni.service;

import java.util.List;

import soongni.domain.BusiMember;

public interface BusiMemberService {
  List<BusiMember> list(int pageNo, int pageSize) throws Exception;
  void add(BusiMember busiMember) throws Exception;
  BusiMember brandMemberBrand(int ceono)throws Exception;

  /*Code get(int no) throws Exception;
  Code getByEmailPassword(String email, String password) throws Exception;
  int getSize() throws Exception;
  
  void update(Code code) throws Exception;
  void remove(int no) throws Exception;*/
}







