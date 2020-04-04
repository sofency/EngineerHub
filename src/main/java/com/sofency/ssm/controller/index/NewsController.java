package com.sofency.ssm.controller.index;

import com.sofency.ssm.pojo.Message;
import com.sofency.ssm.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author sofency
 * @date 2020/4/1 22:11
 * @package IntelliJ IDEA
 * @description
 */
@Controller
@RequestMapping("/index")
public class NewsController {

    private MessageService messageService;
    @Autowired
    public NewsController(MessageService messageService){
        this.messageService = messageService;
    }

    @RequestMapping("/news")
    public String news(Model model){
        List<Message> messages = messageService.getMsgs();
        model.addAttribute("messages",messages);
        return "indexPage/news";
    }
    @RequestMapping("/messageDetail/{msgId}")
    public String messageDetail(@PathVariable("msgId") Integer msgId, Model model){
        //根据文章的id查询消息
        Message message = messageService.findById(msgId);
        model.addAttribute("messageDetail",message);
        return "indexPage/NewsDetail";
    }
}
