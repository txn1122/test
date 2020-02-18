package com.example.servicecompanyinfo.controller;

import com.example.servicecompanyinfo.entity.company;
import com.example.servicecompanyinfo.result.Constants;
import com.example.servicecompanyinfo.result.Result;
import com.example.servicecompanyinfo.result.ResultGenerator;
import com.example.servicecompanyinfo.service.companyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/company")
@Api(value = "企业模块")
public class companyController {
    @Autowired
    private companyService comService;

    //添加
    @ApiOperation(value = "添加企业",notes = "添加新的企业")
    @GetMapping("/add")
    public Result save(company com) {
        if (StringUtils.isEmpty(com.getName()) || StringUtils.isEmpty(com.getLegalRepresentative()) || StringUtils.isEmpty(com.getUscCode()) || StringUtils.isEmpty(com.getBusinessRegisNo())) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        if (comService.save(com) == 0) {
            return ResultGenerator.genSuccessResult(com);
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    //更新
    @ApiOperation(value = "修改企业信息",notes = "根据企业ID修改对应的企业信息")
    @PutMapping("update")
    public Result updateCompany(company com, @RequestHeader(value = "id") String id) {

        //验证参数
        if (id == null) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }

        int flag = comService.update(com,id);
        //查询数据库 排除无此用户的问题
        if (flag ==-1) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "用户不存在！");
        }
        //修改记录
        if (flag == 0) {
            return ResultGenerator.genSuccessResult(com);
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }


    //根据id查询
    @ApiOperation(value = "查找企业",notes = "根据企业ID查找对应的企业")
    @ApiImplicitParam(name = "id", value = "企业ID", required = true, dataType = "String")
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable String id) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(id)){
            result.setMessage("请输入企业ID");
            return result;
        }
        company com = comService.findCompanyById(id);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据name查询
    @ApiOperation(value = "查找企业",notes = "根据企业名称查找对应的企业")
    @ApiImplicitParam(name = "name", value = "企业名称", required = true, dataType = "String")
    @GetMapping("/findByName/{name}")
    public Result findByName(@PathVariable String name) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(name)){
            result.setMessage("请输入企业名称");
            return result;
        }
        List<company> com = comService.findCompanyByName(name);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据nature查询
    @ApiOperation(value = "查找企业",notes = "根据企业性质查找对应的企业")
    @ApiImplicitParam(name = "nature", value = "企业性质", required = true, dataType = "String")
    @GetMapping("/findByNature/{nature}")
    public Result findByNature(@PathVariable String nature) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(nature)){
            result.setMessage("请输入企业性质");
            return result;
        }
        List<company> com = comService.findCompanyByNature(nature);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据type查询
    @ApiOperation(value = "查找企业",notes = "根据企业类型查找对应的企业")
    @ApiImplicitParam(name = "type", value = "企业类型", required = true, dataType = "String")
    @GetMapping("/findByType/{type}")
    public Result findByType(@PathVariable String type) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(type)){
            result.setMessage("请输入企业类型");
            return result;
        }
        List<company> com = comService.findCompanyByType(type);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据businessRegisNo查询
    @ApiOperation(value = "查找企业",notes = "根据工商注册号查找对应的企业")
    @ApiImplicitParam(name = "No", value = "工商注册号", required = true, dataType = "String")
    @GetMapping("/findByBRNo/{No}")
    public Result findByBusinessRegisNo(@PathVariable String No) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(No)){
            result.setMessage("请输入工商注册号");
            return result;
        }
        company com = comService.findCompanyByBusinessRegisNo(No);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据uscCode查询
    @ApiOperation(value = "查找企业",notes = "根据统一社会信用代码查找对应的企业")
    @ApiImplicitParam(name = "code", value = "统一社会信用代码", required = true, dataType = "String")
    @GetMapping("/findByUscCode/{code}")
    public Result findByUscCode(@PathVariable String code) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(code)){
            result.setMessage("请输入统一社会信用代码");
            return result;
        }
        company com = comService.findCompanyByUscCode(code);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }


    //根据name模糊查询
    @ApiOperation(value = "查找企业",notes = "根据企业名称进行模糊查询")
    @ApiImplicitParam(name = "name", value = "企业名称", required = true, dataType = "String")
    @GetMapping("/findByNameLike/{name}")
    public Result findByNameLike(@PathVariable String name) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(name)){
            result.setMessage("请输入可能的企业名称");
            return result;
        }
        List<company> com = comService.findByNameLike(name);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //根据businessScope模糊查询
    @ApiOperation(value = "查找企业",notes = "根据经营范围进行模糊查询")
    @ApiImplicitParam(name = "scope", value = "经营范围", required = true, dataType = "String")
    @GetMapping("/findByBusinessScopeLike/{scope}")
    public Result findByBusinessScopeLike(@PathVariable String scope) {
        Result result = ResultGenerator.genFailResult("查找失败");
        if(StringUtils.isEmpty(scope)){
            result.setMessage("请输入经营范围");
            return result;
        }
        List<company> com = comService.findByBusinessScopeLike(scope);
        if(com != null){
            return ResultGenerator.genSuccessResult(com);
        }
        return result;
    }

    //查询所有信息
    @ApiOperation(value = "查找所有企业",notes = "")
    @GetMapping("/queryall")
    public Result findByPage(Integer page , HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin","*");//异步请求响应头

        if(page==null || page<=0){
            page = 0;
        }else{
            page -= 1;
        }
        return ResultGenerator.genSuccessResult(comService.findAll(page,5));
    }
}
