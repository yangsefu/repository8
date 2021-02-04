package com.clive.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.clive.bean.Items;
import com.clive.service.ItemService;

@Controller
public class ItemsController {
  @Autowired
  private ItemService itemService;
  @RequestMapping("/item")
  public ModelAndView showIndex() {
	  List<Items> list = itemService.findItemsAll();
      ModelAndView andView = new ModelAndView();
      andView.addObject("itemList", list);
      andView.setViewName("itemList");
      return andView;
  }
  @RequestMapping("/showUpdate")
  public String showUpdate(Integer id,Model model) {
	  Items items = itemService.findItemsById(id);
	  model.addAttribute("item",items);
	  return "editItem";
  }
//  @RequestMapping("/updateitem")
//  public String updateitem(Items items) {
//	 int count = itemService.updateitem(items);
//	 if(count>0) {
////			response.sendRedirect(location);
////		 request.getRequestDispatcher("").forward(request, response);
//			return "redicrect:/item.action";
//		}
//	  return "forward:/showUpdate.action?id = "+items.getId();
//  }
  @RequestMapping("/updateitem")
  public String updateitem(Items items,MultipartFile pictureFile) {
	 int count = itemService.updateitem(items,pictureFile);
	 if(count>0) {

			return "redirect:/item.action";
		}
	  return "forward:/showUpdate.action?id="+items.getId();
  }
}
