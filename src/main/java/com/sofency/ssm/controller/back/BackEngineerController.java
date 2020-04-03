package com.sofency.ssm.controller.back;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sofency.ssm.pojo.Institute;
import com.sofency.ssm.service.interfaces.EngineerService;
import com.sofency.ssm.service.interfaces.InstituteMajorService;
import com.sofency.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sofency.ssm.pojo.Engineer;

@Controller
@RequestMapping("/back")
public class BackEngineerController {
	
	private final Logger LOG = LoggerFactory.getLogger(BackEngineerController.class);
	private EngineerService engineerService;
	private InstituteMajorService instituteMajorService;

	@Autowired
	public BackEngineerController(EngineerService engineerService, InstituteMajorService instituteMajorService) {
		this.engineerService = engineerService;
		this.instituteMajorService = instituteMajorService;
	}

	//查询工作室人员的信息返回到官网的后端
	@GetMapping("/engineers/{page}")
	public ModelAndView showEngineerInfoToManager(@PathVariable("page")int page) {
		ModelAndView model = new ModelAndView();
		
		List<Institute> institutes = instituteMajorService.getInstitutes();//获取院系
		PageHelper.startPage(page, 3);//每页显示四个数据
		List<Engineer> list=engineerService.getAll();
		PageInfo<Engineer> pages = new PageInfo<>(list);
		model.addObject("pages", pages);
		model.addObject("EngineerCustom", list);
		model.addObject("institutes", institutes);//获取院系
		model.setViewName("manager/PersonManager");
		LOG.info("\n"+ DateUtil.getCurrentTime()+"查询工作时人员信息");
		return model;
	}
	//插入工作室人员的信息
	@ResponseBody
	@PostMapping("/insertEngineer")
	public Map<String, String> insertEngineer(HttpServletRequest request, @RequestParam(required = false) MultipartFile file, Engineer engineer) throws IllegalStateException, IOException {
		//接受多个文件
	   String newImageName = null;
	   if(file!=null&&file.getSize()!=0) {
		   String originalName = file.getOriginalFilename(); 
	       String uuidName = UUID.randomUUID().toString(); 
	       newImageName = uuidName + originalName.substring(originalName.lastIndexOf("."));
		   File imageFile = new File("E:\\Java\\EngineerHub\\src\\main\\webapp\\staticfile\\img\\"+newImageName);
	       file.transferTo(imageFile); 
	       engineer.setEngineerImgPath(new String("/EngineerHub/staticfile/img/" +newImageName));
	   }else{
		   engineer.setEngineerImgPath(null);
	   }
	   engineer.setEngineerEmail("mailto:"+engineer.getEngineerEmail());
	   engineerService.insertEngineer(engineer);
       LOG.info("\n"+DateUtil.getCurrentTime()+"--执行了插入操作"+engineer.toString());

       Map<String,String> map= new HashMap<>();
       map.put("code","200");
       map.put("message","修改成功");
       return map;
   }

   //根据名字查找用户
	@GetMapping("/engineerhub/{name}")
	@ResponseBody
	public List<Engineer> findEngineerInfoByName(HttpServletRequest request,@PathVariable("name") String username){
		List<Engineer> list = engineerService.findEngineerInfoByName(username);
		LOG.info("\n"+DateUtil.getCurrentTime()+": 根据名字模糊查找了"+username);
		return list;
	}	
	
	@RequestMapping("/GetInfo/{id}")
	@ResponseBody
	public Engineer GetInfo(@PathVariable("id") Integer id) {
		//首先在redis中查找用户
		Engineer engineer = engineerService.GetInfo(id);
		LOG.info("\n"+DateUtil.getCurrentTime()+": 根据id"+id+"向数据库中查询用户");
		return engineer;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, String> keepInfo(Engineer engineer, MultipartFile file) throws IllegalStateException, IOException {
		//接受多个文件
		String newImageName = null;
		if(file!=null&&file.getSize()!=0){
			String originalName = file.getOriginalFilename();
			String uuidName = UUID.randomUUID().toString();
			newImageName = uuidName + originalName.substring(originalName.lastIndexOf("."));
			File imageFile = new File("E:\\Java\\EngineerHub\\src\\main\\webapp\\staticfile\\img\\"+newImageName);
			file.transferTo(imageFile);
			engineer.setEngineerImgPath(new String("/EngineerHub/staticfile/img/" + "/"+newImageName));
		}else {
			engineer.setEngineerImgPath(null);
		}
        engineerService.save(engineer);
        LOG.info("\n"+DateUtil.getCurrentTime()+"更新人员信息"+engineer);
		Map<String,String> map= new HashMap<>();
		map.put("code","200");
		map.put("message","修改成功");
        return map;
	}
	
	@ResponseBody
	@DeleteMapping("/delete/{id}")
	public String deleteInfo(@PathVariable("id") Integer id) {
		int flag = engineerService.delete(id);
		LOG.info("\n"+DateUtil.getCurrentTime()+"删除用户id="+id);
		if(flag>=0) {
			return "true";
		}else {
			return "false";
		}
	}
}
