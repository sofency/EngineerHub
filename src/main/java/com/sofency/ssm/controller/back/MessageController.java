package com.sofency.ssm.controller.back;

import com.github.pagehelper.PageHelper;
import com.sofency.ssm.pojo.Message;
import com.sofency.ssm.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sofency
 * @date 2020/4/1 12:12
 * @package IntelliJ IDEA
 * @description
 */
@Controller
public class MessageController {

    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @RequestMapping("/message")
    public String message(){
        return "manager/message";
    }

    @RequestMapping("/sendMsg")
    public String sendMsg(Message message,Model model){
        Map<String,Object> msg = new HashMap<>();
        if(message==null || message.getMsgHeader()==""|| message.getMsgContent()==""){//如果没有写标题 或者没有写内容就退出
            return "redirect:message";
        }else{//插入到数据库中
            message.setMsgTime(new Date(System.currentTimeMillis()));
            System.out.println(message.getMsgTime());
            int i = messageService.insertMsg(message);
            if(i>0){
                return "redirect:/messages";
            }else{
                return "redirect:message";
            }
        }
    }
    @RequestMapping("/messages")
    public ModelAndView sendMsg(){
        List<Message> messages = messageService.getMsgs();
        ModelAndView modelAndView = new ModelAndView();
        if(messages!=null&&messages.size()!=0){
            modelAndView.addObject("messages",messages);
        }else {
            modelAndView.addObject("msg","无消息发送");
        }
        modelAndView.setViewName("/manager/messages");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/deleteMsg")
    public String deleteMsg(Integer msgId){
        int i = messageService.deleteMsg(msgId);
        return i==0?"false":"true";
    }
}
