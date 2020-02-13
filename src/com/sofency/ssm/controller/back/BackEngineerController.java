package com.sofency.ssm.controller.back;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineerCustomJson;
import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.service.EngineerService;
import com.sofency.ssm.service.InstitudeMajorService;

@Controller
@RequestMapping("/back")
public class BackEngineerController {
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private InstitudeMajorService institudeMajorService;
	
	//查询工作室人员的信息返回到官网的后端
	@GetMapping("/engineers/{page}")
	public ModelAndView showEngineerInfoToManager(@PathVariable("page")int page) {
		ModelAndView model = new ModelAndView();
		List<Engineer> list=engineerService.selectPartEngineerInfo(page);
		List<Institude> institudes = institudeMajorService.getInstitudes();//获取院系
		//获取总页数
		Integer pages = engineerService.getEngineerNum();
		model.addObject("pages", pages);//添加总页数
		model.addObject("currentPage", page);
		model.addObject("EngineerCustom", list);
		model.addObject("institudes", institudes);//获取院系
		model.setViewName("manager/PersonManager");
		System.out.println(institudes);
		return model;
	}

	@GetMapping("/engineersByJson/{page}")
	@ResponseBody
	public EngineerCustomJson showEngineerInfoToManagerByJson(@PathVariable("page")int page) {
		
		ArrayList<Engineer> list=(ArrayList<Engineer>) engineerService.selectPartEngineerInfo(page);
		List<Institude> institudes = institudeMajorService.getInstitudes();//获取院系
		//获取总页数
		Integer pages = engineerService.getEngineerNum();
		EngineerCustomJson engineers = new EngineerCustomJson();
		engineers.setCurrentPage(page);
		engineers.setPages(pages);
		engineers.setList(list);
		engineers.setInstitude(institudes);
		System.out.println(institudes);
		return engineers;
	}
	
	
	//插入工作室人员的信息
	@RequestMapping("/insertEngineer")
	public String insertEngineer(MultipartFile file,Model model,HttpServletRequest request,Engineer engineer) throws IllegalStateException, IOException {
		//接受多个文件
		String newImageName = null;
		String realPath = "/usr/java/apache-tomcat-8.5.47/webapps/EngineerHub/img"; 
        if (!file.isEmpty()) {    
	        File filePath = new File(realPath);//存储文件的路径
	        if(!filePath.exists()) {
	        	filePath.mkdir();
	        }
	        String originalName = file.getOriginalFilename(); 
	        String uuidName = UUID.randomUUID().toString(); 
	        newImageName = uuidName + originalName.substring(originalName.lastIndexOf("."));  
	        File imageFile = new File(realPath + "/"+newImageName);  
	        file.transferTo(imageFile); 
		}
        engineer.setEngineerImgpath(new String(realPath + "/"+newImageName));
        int flag = engineerService.insertEngineer(engineer);
        if(flag>0) {
        	model.addAttribute("flag","添加成功");
        }else {
        	model.addAttribute("flag","添加失败");
        }
        return "manager/manager";
   }

   //根据名字查找用户
	@GetMapping("/engineerhub/{name}")
	@ResponseBody
	public List<Engineer> findEngineerInfoByName(HttpServletRequest request,@PathVariable("name") String username){
		List<Engineer> list = engineerService.findEngineerInfoByName(username);
		return list;
	}
		

}
