package com.ntg.ui;

import java.util.List;
import java.util.Scanner;

import com.ntg.bean.News;
import com.ntg.bean.Order;
import com.ntg.bean.Order_detail;
import com.ntg.bean.Product;
import com.ntg.bean.Product_category;
import com.ntg.bean.User;
import com.ntg.bean.User_address;
import com.ntg.dao.NewsDao;
import com.ntg.dao.ProductDao;
import com.ntg.dao.UserDao;
import com.ntg.dao.impl.NewsDaoImpl;
import com.ntg.dao.impl.UserDaoImpl;
import com.ntg.service.NewsService;
import com.ntg.service.OrderService;
import com.ntg.service.Order_detailService;
import com.ntg.service.ProductService;
import com.ntg.service.Product_categoryService;
import com.ntg.service.UserService;
import com.ntg.service.User_addressService;
import com.ntg.service.impl.NewsServiceImpl;
import com.ntg.service.impl.OrderServiceImpl;
import com.ntg.service.impl.Order_detailServiceImpl;
import com.ntg.service.impl.ProductServiceImpl;
import com.ntg.service.impl.Product_categoryServiceImpl;
import com.ntg.service.impl.UserServiceImpl;
import com.ntg.service.impl.User_addressServiceImpl;

public class Main {
	static Scanner input = new Scanner(System.in);
	static UserService ss = new UserServiceImpl();
	static NewsService ns = new NewsServiceImpl();
	static User_addressService us = new User_addressServiceImpl();
	static ProductService ps = new ProductServiceImpl();
	static Product_categoryService cats = new Product_categoryServiceImpl();
	static OrderService os = new OrderServiceImpl();
	static Order_detailService ods = new Order_detailServiceImpl();

	public static void main(String[] args) {

		showMenu();// 主菜单
	}

	/**
	 * 主菜单
	 */
	public static void showMenu() {
		System.out
				.println("1.用户相关\n2.用户地址相关\n3.新闻相关\n4.商品相关\n5.商品分类相\n6.订单相关\n7.订单详情相关");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			showUser(); // 用户相关菜单
			break;
		case 2:
			showUserAddress();// 用户地址菜单
			break;
		case 3:
			showNews(); // 新闻相关菜单
			break;
		case 4:
			showPro(); // 商品相关菜单
			break;
		case 5:
			showPro_cat(); // 商品分类相关菜单
			break;
		case 6:
			showOrder(); // 订单相关菜单
			break;
		case 7:
			showOrder_de(); // 订单详情相关菜单
			break;

		}
	}

	/**
	 * 订单详情相关菜单
	 */
	private static void showOrder_de() {
		System.out
				.println("1.订单详情新增\n2.订单详情更改\n3.订单详情删除\n4.订单详情查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			or_deSave();// 新增
			break;
		case 2:
			or_deUpdate();// 更改
			break;
		case 3:
			or_deDelete();// 删除
			break;
		case 4:
			or_deQuery();// 查询
			break;
		case 6:
			showMenu();// 一级菜单
			break;
		case 5:
			oneQuery();// 指定查询
			break;
		}
	}

	/**
	 * 订单详情指定查询
	 */
	private static void oneQuery() {
		System.out.println("输入要查询的id");
		int t = input.nextInt();
		Order_detail id = ods.findById(t);
		System.out.println(id);
	}

	private static void or_deQuery() {
		List<Order_detail> list = ods.query();
		for (Order_detail order_detail : list) {
			System.out.println(order_detail);
		}
	}

	/**
	 * 订单详情删除
	 */
	private static void or_deDelete() {
		System.out.println("输入要删除的id");
		int id = input.nextInt();
		ods.delete(id);
	}

	/**
	 * 订单详情修改
	 */
	private static void or_deUpdate() {
		System.out.println("输入要删除的id");
		int id = input.nextInt();
		System.out.println("输入新订单id");
		int orderId = input.nextInt();
		System.out.println("输入新商品id");
		int productId = input.nextInt();
		System.out.println("输入新数量");
		int quantity = input.nextInt();
		System.out.println("输入新消费");
		float cost = input.nextInt();
		Order_detail t = new Order_detail(id, orderId, productId, quantity,
				cost);
		ods.update(t);
	}

	/**
	 * 订单详情新增
	 */
	private static void or_deSave() {
		System.out.println("输入订单id");
		int orderId = input.nextInt();
		System.out.println("输入商品id");
		int productId = input.nextInt();
		System.out.println("输入数量");
		int quantity = input.nextInt();
		System.out.println("输入消费");
		float cost = input.nextInt();
		Order_detail t = new Order_detail(orderId, productId, quantity, cost);
		ods.save(t);

	}

	/**
	 * 订单菜单
	 */
	private static void showOrder() {
		System.out.println("1.订单新增\n2.订单更改\n3.订单删除\n4.订单查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			orderSave();// 新增
			break;
		case 2:
			orderUpdate();// 更改
			break;
		case 3:
			orderDelete();// 删除
			break;
		case 4:
			orderQuery();// 查询
			break;
		case 6:
			showMenu();// 一级菜单
			break;
		case 5:
			or_oneQuery();// 一级菜单
			break;
		}
	}

	/**
	 * 订单指定查询
	 */
	private static void or_oneQuery() {
		System.out.println("输入要查寻的id");
		int t = input.nextInt();
		Order id = os.findById(t);
		System.out.println(id);
	}

	/**
	 * 订单查询
	 */
	private static void orderQuery() {
		List<Order> list = os.query();
		for (Order order : list) {
			System.out.println(order);
		}
	}

	/**
	 * 订单删除
	 */
	private static void orderDelete() {
		System.out.println("输入要删除的id");
		int t = input.nextInt();
		os.delete(t);
	}

	/**
	 * 订单更改
	 */
	private static void orderUpdate() {
		System.out.println("输入要修改的订单id");
		int id = input.nextInt();
		System.out.println("输入新用户id");
		int userId = input.nextInt();
		System.out.println("输入新登录名");
		String loginName = input.next();
		System.out.println("输入新用户地址");
		String userAddress = input.next();
		System.out.println("输入新总消费");
		float cost = input.nextFloat();
		System.out.println("输入新订单号");
		String serialNumber = input.next();
		Order order = new Order(id, userId, loginName, userAddress, cost,
				serialNumber);
		os.update(order);
	}

	/**
	 * 订单新增
	 */
	private static void orderSave() {

		System.out.println("输入用户id");
		int userId = input.nextInt();
		System.out.println("输入登录名");
		String loginName = input.next();
		System.out.println("输入用户地址");
		String userAddress = input.next();
		System.out.println("输入总消费");
		float cost = input.nextFloat();
		System.out.println("输入订单号");
		String serialNumber = input.next();
		Order order = new Order(userId, loginName, userAddress, cost,
				serialNumber);
		os.save(order);

	}

	/**
	 * 商品分类相关菜单
	 */
	private static void showPro_cat() {
		System.out
				.println("1.商品分类新增\n2.商品分类更改\n3.商品分类删除\n4.商品分类查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			pro_catSave();// 新增
			break;
		case 2:
			pro_catUpdate();// 更改
			break;
		case 3:
			pro_catDelete();// 删除
			break;
		case 4:
			pro_catQuery();// 查询
			break;
		case 5:
			showMenu();// 一级菜单
			break;
		}
	}

	/**
	 * 商品分类查询
	 */
	private static void pro_catQuery() {
		List<Product_category> list = cats.query();
		for (Product_category product_category : list) {
			System.out.println(product_category);
		}
	}

	/**
	 * 商品分类删除
	 */
	private static void pro_catDelete() {
		System.out.println("输入要删除的id");
		int t = input.nextInt();
		cats.delete(t);

	}

	/**
	 * 商品分类修改
	 */
	private static void pro_catUpdate() {
		System.out.println("输入要修改的分类id");
		int id = input.nextInt();
		System.out.println("输入新的分类名称");
		String name = input.next();
		System.out.println("输入新的父级id");
		int parentId = input.nextInt();
		System.out.println("输入新的分类信息 1.一级 2.二级 3.三级");
		int type = input.nextInt();
		Product_category cat = new Product_category(id, name, parentId, type);
		cats.update(cat);
	}

	/**
	 * 商品分类新增
	 */
	private static void pro_catSave() {
		System.out.println("输入分类名");
		String name = input.next();
		System.out.println("输入父级目录id");
		int parentId = input.nextInt();
		System.out.println("输入级别 1.一级 2.二级 3.三级");
		int type = input.nextInt();
		Product_category cat = new Product_category(name, parentId, type);
		cats.save(cat);
	}

	/**
	 * 商品相关菜单
	 */
	private static void showPro() {
		System.out.println("1.商品新增\n2.商品更改\n3.商品删除\n4.商品查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			proSave();// 新增
			break;
		case 2:
			proUpdate();// 更改
			break;
		case 3:
			proDelete();// 删除
			break;
		case 4:
			proQuery();// 查询
			break;
		case 6:
			showMenu();// 一级菜单
			break;
		case 5:
			pro_Query();// 一级菜单
			break;

		}
	}

	/**
	 * 商品单条查询
	 */
	private static void pro_Query() {
		System.out.println("输入要查询的id");
		int t = input.nextInt();
		Product id = ps.findById(t);
		System.out.println(id);
	}

	/**
	 * 商品删除
	 */
	private static void proQuery() {
		List<Product> list = ps.query();
		for (Product product : list) {
			System.out.println(product);
		}
	}

	/**
	 * 商品删除
	 */
	private static void proDelete() {
		System.out.println("输入要删除删除地址的id");
		int id = input.nextInt();
		ps.delete(id);
	}

	/**
	 * 商品修改
	 */
	private static void proUpdate() {
		System.out.println("输入要更改的ID");
		int id = input.nextInt();
		System.out.println("输入商品名字");
		String name = input.next();
		System.out.println("输入商品描述");
		String description = input.next();
		System.out.println("输入商品价格");
		int price = input.nextInt();
		System.out.println("输入商品库存");
		int stock = input.nextInt();
		System.out.println("输入分类1");
		int categoryLevel1Id = input.nextInt();
		System.out.println("输入分类2");
		int categoryLevel2Id = input.nextInt();
		System.out.println("输入分类3");
		int categoryLevel3Id = input.nextInt();
		System.out.println("输入文件名字");
		String fileName = input.next();
		System.out.println("是否删除 1.删除 0.没有删除");
		int isDelete = input.nextInt();
		Product p = new Product(id, name, description, price, stock,
				categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName,
				isDelete);
		ps.update(p);
	}

	/**
	 * 商品新增
	 */
	private static void proSave() {
		System.out.println("输入商品名字");
		String name = input.next();
		System.out.println("输入商品描述");
		String description = input.next();
		System.out.println("输入商品价格");
		int price = input.nextInt();
		System.out.println("输入商品库存");
		int stock = input.nextInt();
		System.out.println("输入分类1");
		int categoryLevel1Id = input.nextInt();
		System.out.println("输入分类2");
		int categoryLevel2Id = input.nextInt();
		System.out.println("输入分类3");
		int categoryLevel3Id = input.nextInt();
		System.out.println("输入文件名字");
		String fileName = input.next();
		System.out.println("是否删除 1.删除 0.没有删除");
		int isDelete = input.nextInt();
		Product p = new Product(name, description, price, stock,
				categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName,
				isDelete);
		ps.save(p);
	}

	/**
	 * 用户地址相关
	 */
	private static void showUserAddress() {
		System.out.println("1.地址新增\n2.地址更改\n3.地址删除\n4.地址查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			addsSave();// 新增
			break;
		case 2:
			addsUpdate();// 更改
			break;
		case 3:
			addsDelete();// 删除
			break;
		case 4:
			addsQuery();// 查询
			break;
		case 6:
			showMenu();// 一级菜单
			break;
		case 5:
			usdQuery();// 一级菜单
			break;

		}
	}

	/**
	 * 用户地址指定查询
	 */
	private static void usdQuery() {
		System.out.println("输入你要查询的id");
		int t = input.nextInt();
		User_address byId = us.findById(t);
		System.out.println(byId);
	}

	/**
	 * 用户地址查询
	 */
	private static void addsQuery() {
		List<User_address> query = us.query();
		for (User_address user_address : query) {
			System.out.println(user_address);
		}
	}

	/**
	 * 删除用户地址
	 */
	private static void addsDelete() {
		System.out.println("输入要删除删除地址的id");
		int id = input.nextInt();
		us.delete(id);
	}

	/**
	 * 用户地址更改
	 */
	private static void addsUpdate() {
		System.out.println("输入要修改地址的编号");
		int id = input.nextInt();
		System.out.println("输入新用户id");
		int userId = input.nextInt();
		System.out.println("输入新地址");
		String address = input.next();
		System.out.println("是不是默认地址 1.是 0.不是");
		int isDefault = input.nextInt();
		System.out.println("新备注");
		String remark = input.next();
		User_address user_add = new User_address(id, userId, address,
				isDefault, remark);
		us.save(user_add);
	}

	/**
	 * 用户地址新增
	 */
	private static void addsSave() {
		System.out.println("输入用户id");
		int userId = input.nextInt();
		System.out.println("输入地址");
		String address = input.next();
		System.out.println("是不是默认地址 1.是 0.不是");
		int isDefault = input.nextInt();
		System.out.println("备注");
		String remark = input.next();
		User_address user_add = new User_address(userId, address, isDefault,
				remark);
		us.save(user_add);
	}

	/**
	 * 新闻相关菜单
	 */
	private static void showNews() {
		System.out.println("1.新闻新增\n2.新闻更改\n3.新闻删除\n4.新闻查询\n5.指定查询\n6.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			newsSave();// 新增
			break;
		case 2:
			newsUpdate();// 更改
			break;
		case 3:
			newsDelete();// 删除
			break;
		case 4:
			newsQuery();// 查询
			break;
		case 6:
			showMenu();// 一级菜单
			break;
		case 5:
			newQuery();// 指定查询
			break;

		}
	}

	/**
	 * 新闻指定查询
	 */
	private static void newQuery() {
		System.out.println("输入你要查询的id");
		int t = input.nextInt();
		News byId = ns.findById(t);
		System.out.println(byId);
	}

	/**
	 * 新闻删除
	 */
	private static void newsDelete() {
		System.out.println("选择删除方式  1.编号  2.标题");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			System.out.println("输入新闻id进行删除");
			int id = input.nextInt();
			ns.delete(id);
			break;
		case 2:
			System.out.println("输入新闻标题进行删除");
			String s = input.next();
			ns.delete(s);
			break;

		}

	}

	/**
	 * 新闻修改
	 */
	private static void newsUpdate() {
		System.out.println("输入新的标题");
		String title = input.next();
		System.out.println("输入新的内容");
		String content = input.next();
		System.out.println("输入你要更改的编号");
		int id = input.nextInt();
		News t = new News(id, title, content);
		ns.update(t);
	}

	/**
	 * 新闻查询
	 */
	private static void newsQuery() {
		List<News> list = ns.query();
		for (News news : list) {
			System.out.println(news);
		}
	}

	/**
	 * 新闻新增
	 */
	private static void newsSave() {
		System.out.println("输入标题");
		String title = input.next();
		System.out.println("输入内容");
		String content = input.next();
		News t = new News(title, content);
		ns.save(t);
	}

	/**
	 * 二级菜单
	 */
	private static void showUser() {
		System.out
				.println("1.用户登录\n2.用户新增\n3.用户更改\n4.用户删除\n5.用户查询\n6.指定查询\n7.返回上一级菜单");
		System.out.println("请选择:");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			userLogin();// 登录
			break;
		case 2:
			userSave();// 新增
			break;
		case 3:
			userUpdate();// 更改
			break;
		case 4:
			userDelete();// 删除
			break;
		case 5:
			userQuery();// 查询
			break;
		case 7:
			showMenu();
			break;
		case 6:
			uQuery();
			break;

		}
	}

	private static void uQuery() {
		System.out.println("要查询的id");
		int t = input.nextInt();
		User findById = ss.findById(t);
		System.out.println(findById);
	}

	/**
	 * 用户删除
	 */
	private static void userDelete() {
		System.out.println("选择修改方式 1.用户名 2.id");
		switch (input.nextInt()) {
		case 1:
			System.out.println("输入用户名");
			String t = input.next();
			ss.delete(t);
			break;
		case 2:
			System.out.println("输入id");
			int ti = input.nextInt();
			ss.delete(ti);
			break;

		}
	}

	/**
	 * 用户更改
	 */
	private static void userUpdate() {

		System.out.println("输入更新用户编号：");
		int id = input.nextInt();
		System.out.println("输入更新登录名：");
		String loginName = input.next();
		System.out.println("输入更新用户名：");
		String userName = input.next();
		System.out.println("输入更新密码：");
		String password = input.next();
		System.out.println("输入更新性别(1.男0.女)：");
		int sex = input.nextInt();
		System.out.println("输入更新身份证：");
		String identityCode = input.next();
		System.out.println("输入更新邮箱：");
		String email = input.next();
		System.out.println("输入更新手机号码：");
		String mobile = input.next();
		System.out.println("输入更新类型(1.管理0.普通)：");
		int type = input.nextInt();
		User user1 = new User(id, loginName, userName, password, sex,
				identityCode, email, mobile, type);
		ss.update(user1);

	}

	/**
	 * 用户查询
	 */
	private static void userQuery() {
		List<User> list = ss.query();
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * 用户新增
	 */
	private static void userSave() {
		System.out.println("输入登录名");
		String loginName = input.next();
		System.out.println("输入用户名");
		String userName = input.next();
		System.out.println("输入密码");
		String password = input.next();
		System.out.println("输入性别 1男 0女");
		int sex = input.nextInt();
		System.out.println("输入身份证号");
		String identityCode = input.next();
		System.out.println("输入邮箱");
		String email = input.next();
		System.out.println("输入手机号");
		String mobile = input.next();
		System.out.println("输入类型 1管理员 0普通");
		int type = input.nextInt();
		User t = new User(loginName, userName, password, sex, identityCode,
				email, mobile, type);
		ss.save(t);
	}

	/**
	 * 用户登录
	 */
	private static void userLogin() {
		System.out.println("输入用户名:");
		String loginName = input.next();
		System.out.println("输入密码:");
		String password = input.next();
		User user = ss.login(loginName, password);
		System.out.println(user.getUserName());
		System.out.println(user.getId());
	}
}
