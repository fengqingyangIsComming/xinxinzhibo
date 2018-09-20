package cc.mrbird.merchant.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.FileUtils;
import cc.mrbird.merchant.domain.DpOrder;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.ChartService;
import cc.mrbird.merchant.service.MerchantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by  AndyZhou
 * 2018/9/5   09:21
 */
@Controller
public class ChartController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MerchantService merchantService;
	@Autowired
	private ChartService chartService;

	@RequestMapping("chartInfo")
	public String merchantInfo() {
		return "merchant/chart/chartInfo";
	}

	/**
	 * 获取数据信息
	 *
	 * @param request
	 * @param dpShop
	 * @param dpOrder
	 * @return
	 */
	@RequestMapping("chartInfo/list")
	@ResponseBody
	public Map<String, Object> merchantInfoList(QueryRequest request, DpShop dpShop, DpOrder dpOrder) {

		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		List<Map> list = this.merchantService.findByChart(dpShop, dpOrder);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return getDataTable(pageInfo);
	}

	/**
	 * 获取财务详情
	 *
	 * @param dpShopUser
	 * @param shopUserId
	 * @return
	 */
	@RequestMapping("finance/getChartInfo")
	@ResponseBody
	public ResponseBo getMerchant(DpShopUser dpShopUser, Integer shopUserId) {
		dpShopUser.setId(shopUserId);
		Map<String, Object> map = this.chartService.findByChartID(dpShopUser);
		return ResponseBo.ok(map);
	}

	/**
	 * excel报表
	 *
	 * @param
	 * @return
	 */
	@RequestMapping("chart/excel")
	@ResponseBody
	public ResponseBo chartExcel(DpShop dpShop) {
		try {
			List<DpShop> list = this.merchantService.findChartWithOrder(dpShop);
			return FileUtils.createExcelByPOIKit("商家统计图表", list, DpShop.class);
		} catch (Exception e) {
			log.error("导出用户信息Excel失败", e);
			return ResponseBo.error("导出Excel失败，请联系网站管理员！");
		}
	}

	/**
	 * excel 报表
	 *
	 * @param dpShop
	 * @return
	 */
	@RequestMapping("chart/csv")
	@ResponseBody
	public ResponseBo chartCsv(DpShop dpShop) {
		try {
			List<DpShop> list = this.merchantService.findChartWithOrder(dpShop);
			return FileUtils.createExcelByPOIKit("商家统计图表", list, DpShop.class);
		} catch (Exception e) {
			log.error("导出用户信息Csv失败", e);
			return ResponseBo.error("导出Csv失败，请联系网站管理员！");
		}
	}
}
