package cc.mrbird.merchant.controller;

import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.service.RoomOnLineUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * Created by  AndyZhou
 * 2018/9/14   14:29
 */
@Controller
public class LiveStreamingController {
	@Autowired
	private RoomOnLineUserService roomOnLineUserService;

	@RequestMapping("live/idList")
	@ResponseBody
	public ResponseBo liveInfo() {

		PageHelper.startPage(1, 10);

		List<Map> allIds = roomOnLineUserService.findAllIds();

		PageInfo<Map> pageInfo = new PageInfo<>(allIds);

		return ResponseBo.ok(pageInfo);

	}

	@RequestMapping("/zhibo")
	public String liveList() {

		return "web/zhibo/index.html";
	}

}
