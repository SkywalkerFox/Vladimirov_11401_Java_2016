package ru.kpfu.itis.PAVEL_VLADIMIROV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;

import java.util.List;

/**
 * Created by Павел on 05.05.2016.
 */
@Repository
public interface SentSuppliesRepository extends JpaRepository<SentSupplies, Integer> {
    @Query("select s from SentSupplies s where s.senderId = :id")
    List<SentSupplies> getAllForId(@Param("id") Integer id);
}
