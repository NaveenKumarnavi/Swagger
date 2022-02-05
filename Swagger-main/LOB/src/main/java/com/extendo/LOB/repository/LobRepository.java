package com.extendo.LOB.repository;

import com.extendo.LOB.entity.Lob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

//@Repository
public interface LobRepository extends JpaRepository<Lob,String> {


	Lob findByLobCode(String lobCode);

    Lob findByLobDescription(String lobDescription);

    Lob findByLobShortDescription(String lobShortDescription);

    Lob findByLobUrl(String lobUrl);

    Lob findByLobDescriptionByLink(String lobDescriptionByLink);

    Lob findByLobEffectiveFromDate(Date lobEffectiveFromDate);

    Lob findByLobEffectiveTill(Date lobEffectiveTill);

    String deleteByLobCode(String lobCode);


    @Query(value = "select * from new_table",nativeQuery = true)
    List<Lob> findCode();

    //@Query("SELECT a FROM Lob a WHERE lobCode = ?1 AND lobDescription = ?2")
   // List<Lob> findLobByData(String lobCode, String lobDescription);

    @Query(value ="select lobCode from new_table lobCode where lobCode = ?1",nativeQuery = true)
    List<Lob>  findLobCode(String lobCode);



}
