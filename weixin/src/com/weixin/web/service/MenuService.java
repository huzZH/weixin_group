package com.weixin.web.service;

import org.springframework.stereotype.Service;

import com.weixin.web.bean.menu.Button;
import com.weixin.web.bean.menu.SecondButton;

@Service
public interface MenuService {
	
	public void createMainMenu(String param);
	
	public void createSubMenu(SecondButton[] subButtons);
	
	public void updateMainMenu(Button[] buttons);
	
	public void updateSubMenu(SecondButton[] subButtons);

	public void deleteMainMenu(Button[] buttons);
	
	public void deleteSubMenu(SecondButton[] subButtons);
	
	public void queryMenu();
	
}
