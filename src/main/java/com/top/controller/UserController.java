package com.top.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.top.pojo.Follow;
import com.top.pojo.Post;
import com.top.pojo.User;
import com.top.service.FollowService;
import com.top.service.PostService;
import com.top.service.UserService;
import com.top.utlis.MessageUtils;
import com.top.utlis.RespBean;

import com.top.dao.entity.Follow;
import com.top.dao.entity.Post;
import com.top.dao.entity.User;
import com.top.service.FollowService;
import com.top.service.PostService;
import com.top.service.UserService;
import com.top.utils.MessageUtils;
import com.top.utils.RespBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private FollowService followService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("toLogin")
	public String toLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("login")
	public String login(User user, Model model, HttpServletRequest request) {
		User one = userService.getOne(new QueryWrapper<User>().eq("email", user.getEmail()).eq("password", user.getPassword()));
		if (!ObjectUtils.isEmpty(one)) {
			one.setList(followService.list(new QueryWrapper<Follow>().eq("user_id", one.getId())));
			request.getSession().setAttribute("user", one);
			return "redirect:/user/detail/" + one.getId();
		}
		model.addAttribute("error", "Incorrect username or password");
		return "login";
	}
	
	@RequestMapping("register")
	public String register(User user,Model model){
		User one = userService.getOne(new QueryWrapper<User>().eq("email", user.getEmail()));
		if (ObjectUtils.isEmpty(one)) {
			userService.save(user);
			return "redirect:/user/toLogin";
		}
		model.addAttribute("error","Email has been registered");
		return "register";
	}
	
	@RequestMapping("upd")
	public String upd(User user) {
		userService.updateById(user);
		return "redirect:/user/findPage/1/3";
		
	}
	
	@RequestMapping("updUser")
	public String updUser(User user, HttpServletRequest request) {
		userService.updateById(user);
		User u = userService.getById(user.getId());
		request.getSession().setAttribute("user", u);
		return "redirect:/user/detail/" + user.getId();
	}
	
	@RequestMapping("findUser/{id}")
	@ResponseBody
	public RespBean findUserById(@PathVariable Integer id) {
		User user = userService.getById(id);
		if (!ObjectUtils.isEmpty(user)) {
			return RespBean.success(MessageUtils.QUERY_SUCCESS, user);
		}
		return RespBean.error(MessageUtils.QUERY_FAIL);
	}
	
	@RequestMapping("detail/{id}")
	public String detailUser(@PathVariable Integer id, Model model,HttpServletRequest request) {
		Object u = request.getSession().getAttribute("user");
		if (ObjectUtils.isEmpty(u)) {
			return "redirect:/user/toLogin";
		}
		User user = userService.getById(id);
		List<Follow> followList = followService.list(new QueryWrapper<Follow>().eq("user_id", id));
		followList.forEach(follow -> {
			follow.setFollow(userService.getById(follow.getFollowId()));
		});
		List<Post> postList = postService.list(new QueryWrapper<Post>().eq("user_id", id));
		postList.forEach(post -> {
			post.setTime(post.getTime().substring(0, post.getTime().length() - 2));
		});
		model.addAttribute("user", user);
		model.addAttribute("postList", postList);
		model.addAttribute("followList", followList);
		model.addAttribute("flag", true);
		return "userCenter";
	}
	
	@RequestMapping("updPassword")
	public String updPassword(Model model, User user, HttpServletRequest request) {
		User user1 = (User) request.getSession().getAttribute("user");
		if (user1.getPassword().equals(user.getPassword())) {
			user.setPassword(user.getNewPassword());
			userService.updateById(user);
			return "redirect:/user/toLogin";
		}
		request.getSession().removeAttribute("user");
		model.addAttribute("error", "Failed to change password");
		return "login";
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile img, Integer id, HttpServletRequest request) throws IOException {
		String propertyPath = System.getProperty("user.dir");
		String filename = UUID.randomUUID().toString();
		InputStream in = img.getInputStream();
		filename += ".jpg";
		userService.updImg(id, filename);

		FileOutputStream fos = new FileOutputStream(propertyPath + "\\target\\classes\\templates\\res\\images\\avatar\\" + filename);

		FileOutputStream fos = new FileOutputStream(propertyPath + "/target/classes/templates/res/images/avatar/" + filename);

		FileOutputStream fos = new FileOutputStream(propertyPath + "\\target\\classes\\templates\\res\\images\\avatar\\" + filename);

		byte bf[] = new byte[1024];
		int l = 0;
		while ((l = in.read(bf)) != -1) {
			fos.write(bf, 0, l);
		}
		in.close();
		fos.close();

		img.transferTo(new File(propertyPath + "\\src\\main\\resources\\templates\\res\\images\\avatar\\" + filename));

		img.transferTo(new File(propertyPath + "/src/main/resources/templates/res/images/avatar/" + filename));

		img.transferTo(new File(propertyPath + "\\src\\main\\resources\\templates\\res\\images\\avatar\\" + filename));

		User user = userService.getById(id);
		request.getSession().setAttribute("user", user);
		return "redirect:/user/detail/" + id;
	}
	

	@RequestMapping("addFollow/{userId}/{followId}")
	public String addFollow(@PathVariable Integer userId, @PathVariable Integer followId, HttpServletRequest request) {
		followService.addFollow(userId, followId);
		User one = ((User) request.getSession().getAttribute("user"));
		one.setList(followService.list(new QueryWrapper<Follow>().eq("user_id", userId)));
		return "redirect:/user/detail/" + followId;
	}
	
	@RequestMapping("delFollow/{userId}/{followId}")
	public String delFollow(@PathVariable Integer userId, @PathVariable Integer followId, HttpServletRequest request) {
		followService.remove(new QueryWrapper<Follow>().eq("user_id", userId).eq("follow_id", followId));
		User one = ((User) request.getSession().getAttribute("user"));
		one.setList(followService.list(new QueryWrapper<Follow>().eq("user_id", userId)));
		return "redirect:/user/detail/" + followId;
	}
	
	
	@RequestMapping("findListByNickName")
	public String findListByNickName(String nickname, Model model, HttpServletRequest request) {
		if(ObjectUtils.isEmpty(nickname)){
			Object nickname1 = request.getSession().getAttribute("nickname");
			nickname = nickname1.toString();
		}
		request.getSession().setAttribute("nickname", nickname);
		User user = (User) request.getSession().getAttribute("user");
		List<User> list = userService.list(new QueryWrapper<User>().like("nickname", nickname));
		for (User u : list) {
			for (Follow follow : user.getList()) {
				if (u.getId().equals(follow.getFollowId())) {
					u.setStatus("1");
					break;
				}
			}
		}
		model.addAttribute("userList", list);
		model.addAttribute("flag", true);
		return "searchResult";
	}
	
	@RequestMapping("addFollowByUserId/{userId}/{followId}")
	public String addFollowByUserId(@PathVariable Integer userId, @PathVariable Integer followId, HttpServletRequest request) {
		followService.addFollow(userId, followId);
		User one = ((User) request.getSession().getAttribute("user"));
		one.setList(followService.list(new QueryWrapper<Follow>().eq("user_id", userId)));
		return "redirect:/user/findListByNickName";
	}
	
	@RequestMapping("delFollowByUserId/{userId}/{followId}")
	public String delFollowByUserId(@PathVariable Integer userId, @PathVariable Integer followId, HttpServletRequest request) {
		followService.remove(new QueryWrapper<Follow>().eq("user_id", userId).eq("follow_id", followId));
		User one = ((User) request.getSession().getAttribute("user"));
		one.setList(followService.list(new QueryWrapper<Follow>().eq("user_id", userId)));
		return "redirect:/user/findListByNickName";
	}

}
