package com.cyj.core.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyj.core.po.Book;
import com.cyj.core.po.Category;
import com.cyj.core.service.BookService;
import com.cyj.core.service.CategoryService;

@Controller
@RequestMapping(value="/main")
public class MainController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;
	@RequestMapping("/main")
	public String main(Model model) {
		categoryAction(model);
		recommendAction(model);
		hotAction(model);
		newAction(model);
		newHotAction(model);
		return "main/main";
	}
    //主页左栏目录	
	//@RequestMapping(value="/categoryAction")
	 private void categoryAction(Model model) {
		List<Category> list = categoryService.findAll();
		
		List<Category> cats = new ArrayList<Category>();
		for (Category c : list) {
			if(c.getParent_id() == 1){
				cats.add(c);
			}
		}
		/**
		 * 根据父目录id获取子目录
		 */
		
		for (Category c : cats) {
			List<Category> subCats = new ArrayList<Category>();
			for (Category sc : list) {
				if(sc.getParent_id() == c.getId()){
					subCats.add(sc);
				}
			}
			//给子目录subCats赋值
			c.setSubCats(subCats);
		}
		model.addAttribute("cats", cats);
	}
	
	//点击主页左栏目录后，所进入页面的左栏目录
	@RequestMapping(value="/booklistAction")
	public String booklistAction(int c1,int c2,Model model) {
		
		 int page = 1;//默认显示第一页
		 int size = 5;
		 int maxPage = 1;
		
		int totalPnum = 0;//商品总数
		int pnum  = 0;
		
		List<Category> cats = categoryService.findByParentId(c1);
		for(Category c:cats) {
			totalPnum += c.getPnum();
			if(c.getId() == c2) {
				pnum = c.getPnum();//获取当前目录下的商品数
			}
		}
		int begin = (page - 1) * size;
		List<Book> books = bookService.findByCatId(c2, begin, size);
		//计算该目录所需页面
		if(pnum==0) {
			maxPage = 1;
		} else if(pnum % size == 0) {
			maxPage = pnum / size;
		} else  {
			maxPage = pnum / size + 1;
		}
		model.addAttribute("cats", cats);
		model.addAttribute("c1", c1);
		model.addAttribute("c2", c2);
		return "main/book_list";
	}
	//书本详细信息
	@RequestMapping(value="/book_view")
	public String book_view(int id,Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return "main/product";
	}
	
	//编辑推荐栏
	/*@RequestMapping(value="/recommendAction")
	public String recommendAction(Model model) {
		List<Book> recommendBooks=new ArrayList<Book>();
		recommendBooks.add(bookService.findById(new Random().nextInt(20)));
		recommendBooks.add(bookService.findById(new Random().nextInt(20)));
		model.addAttribute("recommendBooks", recommendBooks);
		return "main/recommend";
	}*/
	public void recommendAction(Model model) {
		List<Book> recommendBooks=new ArrayList<Book>();
		recommendBooks.add(bookService.findById(new Random().nextInt(20)));
		recommendBooks.add(bookService.findById(new Random().nextInt(20)));
		model.addAttribute("recommendBooks", recommendBooks);
	}
	//热销图书栏
	/*@RequestMapping(value="/hotAction")
	public String hotAction(Model model) {
		List<Book> hotBooks = new ArrayList<Book>();
		for (Book book : bookService.findByHot(4)) {
			hotBooks.add(book);
		}
		model.addAttribute("hotBooks", hotBooks);
		return "main/hot";
	}*/
	public void hotAction(Model model) {
		List<Book> hotBooks = new ArrayList<Book>();
		for (Book book : bookService.findByHot(4)) {
			hotBooks.add(book);
		}
		model.addAttribute("hotBooks", hotBooks);
	}
	//最新上架图书栏	
	/*@RequestMapping(value="/newAction")
	public String newAction(Model model) {
		List<Book> newBooks = new ArrayList<Book>();
		for(Book book : bookService.findByNew(4)){
			newBooks.add(book);
		}
		model.addAttribute("newBooks", newBooks);
		return "main/new";
	}*/
	public void newAction(Model model) {
		List<Book> newBooks = new ArrayList<Book>();
		for(Book book : bookService.findByNew(4)){
			newBooks.add(book);
		}
		model.addAttribute("newBooks", newBooks);
	}
	//最新热卖榜
	/*@RequestMapping(value="/newHotAction")
	public String newHotAction(Model model) {
		List<Book> newHotBooks = new ArrayList<Book>();
		long time = 1000L*60*60*24*30*100;//由于数据库测试数据偏旧，所以给的值略大
		
		for(Book book : bookService.findByNewHot(time)){
			newHotBooks.add(book);
		}
		model.addAttribute("newHotBooks", newHotBooks);
		return "main/hotBoard";
	}
	*/
	public void newHotAction(Model model) {
		List<Book> newHotBooks = new ArrayList<Book>();
		long time = 1000L*60*60*24*30*100;//由于数据库测试数据偏旧，所以给的值略大
		
		for(Book book : bookService.findByNewHot(time)){
			newHotBooks.add(book);
		}
		model.addAttribute("newHotBooks", newHotBooks);
	}

}
