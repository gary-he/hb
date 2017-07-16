package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.FlightSite;
import cn.tarena.ht.pojo.Site;

public interface FlightSiteMapper {
	//查询座位信息
	public List<FlightSite> findFlightSiteList();
	//删除座位信息
	public void deleteFlightSite(String[] sFlightPId);
	//添加座位
	public void saveFlightSite(Site site);
	//修改仓位信息
	public void updateSite(Site site);
	
	public List<Site> findListBySFlightPId(String id);
	

}
