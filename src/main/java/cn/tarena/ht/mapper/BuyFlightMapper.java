package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Flight;
import cn.tarena.ht.pojo.Site;

public interface BuyFlightMapper {

	List<Flight> findAllFlight();

	List<Flight> findFlights(@Param("fl") String fLocation,@Param("fd") String fDeparture);

	List<Flight> findFlightsC(@Param("fl") String fLocation,@Param("fd") String fDeparture,@Param("fc") String fCompany);

	List<Flight> findFlightsT(@Param("fl") String fLocation, @Param("fd") String fDeparture, @Param("fs") String fStarttime);

	List<Flight> findFlightsTC(@Param("fl") String fLocation, @Param("fd") String fDeparture, @Param("fs") String fStarttime,@Param("fc") String fCompany);

	List<Site> finAllSite(@Param("fid") Integer fid);

}
