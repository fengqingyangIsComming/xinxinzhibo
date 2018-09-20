package cc.mrbird.merchant.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.merchant.domain.DpIntegralRecord;
import cc.mrbird.merchant.domain.DpInvitrRecord;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.domain.LiveUserInfo;
import cc.mrbird.merchant.service.DpIntegralRecordService;
import cc.mrbird.merchant.service.DpInvitrRecordService;
import cc.mrbird.merchant.service.LiveUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/4 10:03
 */
@Controller
public class IntegralController extends BaseController {

	@Autowired
	private DpIntegralRecordService dpIntegralRecordService;

	@Autowired
	private LiveUserInfoService liveUserInfoService;

	@Autowired
	private DpInvitrRecordService dpInvitrRecordService;

	@RequestMapping("integralInfo")
	public String merchantInfo() {

		return "merchant/integral/integralInfo";
	}

	/**
	 * 获取积分列表信息
	 *
	 * @param request

	 * @return
	 */
	@RequestMapping("integralInfo/list")
	@ResponseBody
	public Map<String, Object> merchantInfoList(QueryRequest request,DpInvitrRecord dpInvitrRecord) {
		/*Map map = new HashMap();
		if (dpIntegralRecord.getManager() == null) {
			map.put("manager", "");
		} else {
			map.put("manager", dpIntegralRecord.getManager());
		}
		if (dpShopUser.getInvitedCode() == null) {
			map.put("invitedCode", "");
		} else {
			map.put("invitedCode", dpShopUser.getInvitedCode());
		}*/
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		/*List<Map> maps = this.dpIntegralRecordService.findByIntegralRecord(map);
		LiveUserInfo userInfo = new LiveUserInfo();
		for (Map map1 : maps) {
			userInfo.setInviteCode((String) map1.get("invitedCode"));
			LiveUserInfo info = this.liveUserInfoService.findByInviteCode(userInfo);
			map1.put("inviter", info.getUserIdx());
		}*/
		List<Map> byRecord = this.dpInvitrRecordService.findByRecord(dpInvitrRecord);
		PageInfo<Map> pageInfo = new PageInfo<>(byRecord);
		return getDataTable(pageInfo);
	}

	/**
	 * 按时间查询
	 * @param request
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping("integral/list")
	@ResponseBody
	public Map<String, Object> integralsList(QueryRequest request, String startTime, String endTime) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<Map> list = null;

		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

		String startTimes = simpleDateFormat.format(startTime);
		String endTimes 	= simpleDateFormat.format(endTime);*/

		list=dpIntegralRecordService.findByIntegralList(startTime,endTime);

		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}

}
