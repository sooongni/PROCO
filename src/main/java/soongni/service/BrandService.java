package soongni.service;

import java.util.List;

import soongni.domain.Brand;

public interface BrandService {
  List<Brand> list(int pageNo, int pageSize) throws Exception;
  void add(Brand brand) throws Exception;
  List<Brand> listByBrand(String brname) throws Exception;
  Brand get(int no) throws Exception;
  /*Brand getBybrname(String brname) throws Exception;
  int getSize() throws Exception;
  
  void update(Code code) throws Exception;
  void remove(int no) throws Exception;*/
Brand listByBrand2(String brname) throws Exception;
}







