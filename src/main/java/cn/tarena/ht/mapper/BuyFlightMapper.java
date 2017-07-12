package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Flight;

public interface BuyFlightMapper {

	List<Flight> findAllFlight();

	Flight findFlights(@Param("fl") String fLocation,@Param("fd") String fDeparture,@Param("fc") String fCompany);

}
