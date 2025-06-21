package com.cjc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
public class HomeController {
	
	List<Account> list = new ArrayList<>();
	
	@RequestMapping("/reg")
	public String prelogin()
	{
		return "register";
	}
	public void rushi()
	{
		System.out.println("m1 of a");
	}
	@RequestMapping("/regin")
	public String sucData(@ModelAttribute Account acc)
	{
		System.out.println(acc.getAccNo());
		System.out.println(acc.getAdharNo());
		System.out.println(acc.getGender());
		System.out.println(acc.getMobNo());
		System.out.println(acc.getName());
		System.out.println(acc.getUsername());
		System.out.println(acc.getPassword());
		list.add(acc);
		return "success";
	}
	@RequestMapping("/log")
	public String loginData(@RequestParam("username")String un,@RequestParam("password")String ps,Model m)
	{
		System.out.println("usename:"+un);
		System.out.println("password:"+ps);
		
		for(Account ac :list)
		{
			if(ac.getUsername().equals(un)&& ac.getPassword().equals(ps))
			{
				m.addAttribute(ac);
				
				return "transaction";
			}
		}
		
		return "login";
	}
	@RequestMapping("/dipo")
	public String Deeposit(@RequestParam("accNo")String acn,@RequestParam("balance")double bal,Model mm)
	{
		System.out.println("accNo:"+acn);
		System.out.println("balance:"+bal);
		
		for(Account acnt : list)
		{
			if(acnt.getAccNo().equals(acn))
			{
				String newBal=acnt.getBalance()+bal;
				
				acnt.setAccNo(newBal);
				mm.addAttribute(acnt);
			}	
		}
		return "diposit";
	}
		@RequestMapping("/")
}
