package com.weixin.web.task;

import java.util.ArrayList;
import java.util.List;

import com.weixin.web.bean.menu.Button;
import com.weixin.web.bean.menu.ClickButton;
import com.weixin.web.bean.menu.SecondButton;
import com.weixin.web.bean.menu.ViewButton;
import com.weixin.web.config.MenuConstants;
import com.weixin.web.service.MenuService;
import com.weixin.web.service.impl.MenuServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MenuTask {

	private MenuTask() {

	}

	private static MenuTask meuTask = new MenuTask();

	public static MenuTask getInstance() {
		return meuTask;
	}
	/**
	 * 初始化菜单
	 */
	public void initMenu() {
		ClickButton menueOne_subOne = new ClickButton();
		menueOne_subOne.setName("查看中奖名单");
		menueOne_subOne.setType(MenuConstants.CLICK);
		menueOne_subOne.setKey("QUERY");

		ClickButton menueOne_subTwo = new ClickButton();
		menueOne_subTwo.setName("抢200元购物卡");
		menueOne_subTwo.setType(MenuConstants.CLICK);
		menueOne_subTwo.setKey("SHOPPING_CARD");

		List<Button> buttons = new ArrayList<Button>();
		buttons.add(menueOne_subOne);
		buttons.add(menueOne_subTwo);

		SecondButton menueOne = new SecondButton();
		menueOne.setName("200元购物卡");
		menueOne.setSub_button(buttons);

		ViewButton menueTwo = new ViewButton();
		menueTwo.setName("抢公交卡");
		menueTwo.setUrl("http://www.baidu.com");
		menueTwo.setType(MenuConstants.VIEW);

		ViewButton menueThree = new ViewButton();
		menueThree.setName("超级福利");
		menueThree.setUrl("http://www.tudou.com");
		menueThree.setType(MenuConstants.VIEW);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(menueOne);
		jsonArray.add(menueTwo);
		jsonArray.add(menueThree);

		JSONObject json = new JSONObject();
		json.put("button", jsonArray);
		MenuService menuService = new MenuServiceImpl();
		menuService.createMainMenu(json.toString());

	}

}
