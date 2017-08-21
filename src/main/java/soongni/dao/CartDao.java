package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Cart;

public interface CartDao {
	List<Cart> list(int mno);
	int insert(Cart cart);
	int delete(int cartno);
	Cart goodYesorNo(Map<String,Object> valueMap);
	
	/* Code selectOne(int no);
  Code selectOneByEmailPassword(Map<String,Object> valueMap);
  int countAll();

  int delete(int no);
  int update(Code code);
  Svoid insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int codeNo);
  void deletePhoto(int codeNo);*/
	
}
