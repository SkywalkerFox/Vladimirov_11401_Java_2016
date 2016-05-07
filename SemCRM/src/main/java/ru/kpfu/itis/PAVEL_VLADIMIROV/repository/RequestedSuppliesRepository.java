package ru.kpfu.itis.PAVEL_VLADIMIROV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
@Repository
public interface RequestedSuppliesRepository extends JpaRepository<RequestedSupplies, Integer> {
    @Query("select r from RequestedSupplies r where r.requesterId = :id")
    List<RequestedSupplies> getAllForId(@Param("id") Integer id);

    @Query("select r from RequestedSupplies r where r.requesterId = :id and r.date = :date")
    RequestedSupplies getOneByRequesterIdAndDate(@Param("id") Integer id,@Param("date") String date);

    @Transactional
    @Modifying
    @Query("update RequestedSupplies r set r.status = :new_status where r.id = :id")
    void updateRequestStatusById(@Param("id") Integer id, @Param("new_status") String status);

    @Query("select r from  RequestedSupplies r where r.requesterId = :requester_id and r.name = :name and r.status = 'processing' and r.size = :size")
    RequestedSupplies getOneBySendingFormParams(@Param("name") String name, @Param("requester_id") Integer requesterId, @Param("size") Integer size);
}
