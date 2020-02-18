package com.example.servicecompanyinfo.dao;

import com.example.servicecompanyinfo.entity.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface companyRepository extends JpaRepository<company, String> {

    //通过ID查询
    company findCompanyById(String id);
    //通过NAME查询
    List<company> findCompanyByName(String name);
    //通过企业性质NATURE查询
    List<company> findCompanyByNature(String nature);
    //通过企业类型TYPE查询
    List<company> findCompanyByType(String type);
    //通过工商注册号businessRegisNo查询
    company findCompanyByBusinessRegisNo(String BRN);
    //通过统一社会信用代码uscCode查询
    company findCompanyByUscCode(String USC);
    //通过NAME模糊查询
    @Query(value = "select * from company Com where Com.name like %?1%", nativeQuery = true)
    List<company> findByNameLike(@Param("name") String name);
    //通过经营范围BUSINESS_SCOPE模糊查询
    @Query(value = "select * from company Com where Com.business_scope like %?1%", nativeQuery = true)
    List<company> findByBusinessScopeLike(@Param("scope") String scope);

}
