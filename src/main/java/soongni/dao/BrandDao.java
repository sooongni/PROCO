package soongni.dao;

import java.util.List;
import java.util.Map;

import soongni.domain.Brand;

public interface BrandDao {
  List<Brand> selectList(Map<String,Object> valueMap);
  void insert(Brand brand);
  List<Brand> listByBrand(String brname);
  Brand selectOne(int no);
  Brand listByBrand2(String brname);
 

 /*
  
  int countAll();
  
  int delete(int no);
  int update(Code code);
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int codeNo);
  void deletePhoto(int codeNo);*/
}
