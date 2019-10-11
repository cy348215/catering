package com.catering.controller;

import com.catering.pojo.Comment;
import com.catering.pojo.MerchantProfile;
import com.catering.service.CommentService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController_xpy {
    @Autowired
    private CommentService_xpy commentService;

    /**
     * 订单评价
     * @param page
     * @param rows
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/indent_message")
    public String inMess(@RequestParam(required = false,defaultValue = "1")int page,
                         @RequestParam(required = false,defaultValue = "10")int rows,
                         HttpServletRequest request, Model model){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        String type = "订单评价";
        int maxpage = commentService.getMaxPage(rows,type,user.getMerchantId());
        if (page < 1){
            page = 1;
        }
        if (page > maxpage){
            page = maxpage;
        }
        List<Comment> all = commentService.findAllByType(page, rows, type,user.getMerchantId());
        model.addAttribute("comment",all);
        model.addAttribute("page",page);
        model.addAttribute("maxpage",maxpage);
        return "indent_message";
    }

    /**
     * 商品评价
     * @param page
     * @param rows
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/product_message")
    public String proMess(@RequestParam(required = false,defaultValue = "1")int page,
                         @RequestParam(required = false,defaultValue = "10")int rows,
                         HttpServletRequest request, Model model){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        String type = "商品评价";
        int maxpage = commentService.getMaxPage(rows,type,user.getMerchantId());
        if (page < 1){
            page = 1;
        }
        if (page > maxpage){
            page = maxpage;
        }
        List<Comment> all = commentService.findAllByType(page, rows, type,user.getMerchantId());
         model.addAttribute("comment",all);
        model.addAttribute("page",page);
        model.addAttribute("maxpage",maxpage);
        return "product_message";
    }
    //系统消息
    @RequestMapping("/system_message")
    public String sysMess(@RequestParam(required = false,defaultValue = "1")int page,
                          @RequestParam(required = false,defaultValue = "10")int rows,
                          HttpServletRequest request, Model model){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        String type = "系统消息";
        int maxpage = commentService.getMaxPage(rows,type,user.getMerchantId());
        if (page < 1){
            page = 1;
        }
        if (page > maxpage){
            page = maxpage;
        }
        List<Comment> all = commentService.findAllByType(page, rows, type,user.getMerchantId());
        model.addAttribute("comment",all);
        model.addAttribute("page",page);
        model.addAttribute("maxpage",maxpage);
        return "system_message";
    }
    //投诉
    @RequestMapping("/complaint_message")
    public String Complaint(@RequestParam(required = false,defaultValue = "1")int page,
                          @RequestParam(required = false,defaultValue = "10")int rows,
                          HttpServletRequest request, Model model){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        String type = "投诉";
        int maxpage = commentService.getMaxPage(rows,type,user.getMerchantId());
        if (page < 1){
            page = 1;
        }
        if (page > maxpage){
            page = maxpage;
        }
        List<Comment> all = commentService.findAllByType(page, rows, type,user.getMerchantId());
        System.out.println("maxpage"+maxpage);
        model.addAttribute("comment",all);
        model.addAttribute("page",page);
        model.addAttribute("maxpage",maxpage);
        return "complaint_message";
    }
    @RequestMapping("/reply_message")
    public String replymessage(int id,Model model,HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        Comment comment = commentService.findAllById(id,user.getMerchantId());
        model.addAttribute("comm",comment);
        return "reply_message";
    }
    @ResponseBody
    @RequestMapping("/saveComment")
    public int saveComment(String reply,int id){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        Comment comment = new Comment();
        comment.setId(id);
        comment.setDealTime(time);
        comment.setState("已处理");
        comment.setReply(reply);
        System.out.println(comment);
        int i = commentService.updateComment(comment);
        return i;
    }

    @RequestMapping("/delmessage")
    public String delmessage(int id,HttpServletRequest request){
        MerchantProfile user = (MerchantProfile) request.getSession().getAttribute("user");
        commentService.deleteComment(id);
        Comment comment = commentService.findAllById(id, user.getMerchantId());
        if (comment.getType().equals("订单评价")){
            return "redirect:indent_message";
        } else if (comment.getType().equals("投诉")){
            return "complaint_message";
        } else if (comment.getType().equals("商品评价")){
            return "redirect:product_message";
        } else {
            return "redirect:system_message";
        }
    }
}
