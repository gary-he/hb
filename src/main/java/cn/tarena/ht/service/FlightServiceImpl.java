package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.FlightMapper;
import cn.tarena.ht.mapper.FlightSiteMapper;
import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Site;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightMapper flightMapper;
	@Autowired
	private FlightSiteMapper flightSiteMapper;

	@Override
	//查找所有航班信息
	public List<Flight> findAll() {
		return flightMapper.findAll();
	}

	@Override
	//根据fId查询航班详情
	public Flight findOne(String id) {
		return flightMapper.findOne(id);
	}
	
	@Override
	//更新航班信息
	public void updateflight(Flight flight,List<Site> sList) {
		flightMapper.updateFlight(flight);
		for (Site site : sList) {
			if(site.getsId()==null){
				//site.setsFlightPId(flight.getId());
				flightSiteMapper.saveFlightSite(site);
			}
			flightSiteMapper.updateSite(site);
		}
	}

	@Override
	//删除航班信息
	public void deleteFlight(String[] ids) {
		flightMapper.deleteFlight(ids);
		flightSiteMapper.deleteFlightSite(ids);
		
	}
	//航班的新增
	@Override
	public void saveFlight(Flight flight,List<Site> sList) {
		
		flightMapper.saveFlight(flight);
		for (Site site : sList) {
			flightSiteMapper.saveFlightSite(site);
		}
	}

	@Override
	public List<Site> findSiteById(String id) {
		return flightSiteMapper.findListBySFlightPId(id);
	}
	

}
