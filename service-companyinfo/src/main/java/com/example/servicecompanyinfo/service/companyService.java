package com.example.servicecompanyinfo.service;

import com.example.servicecompanyinfo.dao.companyRepository;
import com.example.servicecompanyinfo.entity.company;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class companyService {

    @Autowired
    private companyRepository comRepository;

    //添加
    public int save(company company) {

        comRepository.save(company);
        return 0;
    }


    //根据id查询公司信息
    public company findCompanyById(String id) {

        return comRepository.findCompanyById(id);
    }

    //根据name查询公司信息
    public List<company> findCompanyByName(String name) {

        return comRepository.findCompanyByName(name);
    }

    //通过企业性质nature查询公司信息
    public List<company> findCompanyByNature(String nature) {
        return comRepository.findCompanyByNature(nature);
    }
    //通过企业类型type查询公司信息
    public List<company> findCompanyByType(String type) {
        return comRepository.findCompanyByType(type);
    }
    //通过工商注册号businessRegisNo查询公司信息
    public company findCompanyByBusinessRegisNo(String BRN) {
        return comRepository.findCompanyByBusinessRegisNo(BRN);
    }
    //通过统一社会信用代码uscCode查询公司信息
    public company findCompanyByUscCode(String USC) {
        return comRepository.findCompanyByUscCode(USC);
    }

    //根据name模糊查询
    @Transactional
    public List<company> findByNameLike(String name) {

        return comRepository.findByNameLike(name);
    }

    //通过经营范围businessScope模糊查询
    public List<company> findByBusinessScopeLike(String scope) {

        return comRepository.findByBusinessScopeLike(scope);
    }


    //查询所有
    @Transactional
    public Page<company> findAll(int page, int pageSize) {
        Pageable pageble= PageRequest.of(page,pageSize);
        return comRepository.findAll(pageble);
    }

    //更新
    public int update(company com, String id) {
        Optional<company> companyOptional = comRepository.findById(id);
        if (!companyOptional.isPresent()){
            //return new ResponseResult<>(null,"当前用户不存在",System.currentTimeMillis());
            return -1;
        }else{
            company oldCom =companyOptional.get();
            //log.info("处理后oldCom："+ oldCom.toString());
            // 可以在User上添加校验，保证其数据合法
            //传入的name非空
            if (StringUtils.isNotBlank(com.getName())){
                oldCom.setName(com.getName());
            }
            //传入的name非空
            if (StringUtils.isNotBlank(com.getAddress())){
                oldCom.setAddress(com.getAddress());
            }
            if (StringUtils.isNotBlank(com.getBusinessScope())){
                oldCom.setBusinessScope(com.getBusinessScope());
            }
            if (StringUtils.isNotBlank(com.getEmail())){
                oldCom.setEmail(com.getEmail());
            }
            if (StringUtils.isNotBlank(com.getLegalRepresentative())){
                oldCom.setLegalRepresentative(com.getLegalRepresentative());
            }
            if (StringUtils.isNotBlank(com.getNature())){
                oldCom.setNature(com.getNature());
            }
            if (StringUtils.isNotBlank(com.getTel())){
                oldCom.setTel(com.getTel());
            }
            if (StringUtils.isNotBlank(com.getType())){
                oldCom.setType(com.getType());
            }
            if (StringUtils.isNotBlank(com.getBusinessRegisNo())){
                oldCom.setBusinessRegisNo(com.getBusinessRegisNo());
            }
            if (StringUtils.isNotBlank(com.getUscCode())){
                oldCom.setUscCode(com.getUscCode());
            }
            //log.info("处理后oldcom："+ oldCom.toString());
            try{
                comRepository.save(oldCom);
                return 0;
                //return new ResponseResult<>(oldUser,"",System.currentTimeMillis());
            }catch (Exception e){
                //log.info(e.getMessage());
                //return new ResponseResult<>(null,"更新失败",System.currentTimeMillis());
                return 1;
            }
        }
    }


}
