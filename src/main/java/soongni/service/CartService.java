package soongni.service;

import java.util.List;

import soongni.domain.Cart;

public interface CartService {
  List<Cart> list(int mno) throws Exception;
  void add(Cart cart) throws Exception;
  /*Code get(int no) throws Exception;
  Code getByEmailPassword(String email, String password) throws Exception;
  int getSize() throws Exception;
  
  void update(Code code) throws Exception;
  void remove(int no) throws Exception;*/
void remove(int cartno) throws Exception;
Cart goodYesorNo(int postno, int mno)throws Exception;
}







