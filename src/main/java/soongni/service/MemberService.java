package soongni.service;

import java.util.List;

import soongni.domain.Member;

public interface MemberService {
  List<Member> list(int pageNo, int pageSize) throws Exception;
  void add(Member member) throws Exception;
  Member getByEmailPassword(String email, String password) throws Exception;
  /*Code get(int no) throws Exception;
  Code getByEmailPassword(String email, String password) throws Exception;
  int getSize() throws Exception;
  
  void update(Code code) throws Exception;
  void remove(int no) throws Exception;*/
}







