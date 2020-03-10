package com.example.task.repository;

import com.example.task.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    //@Query("from Task t where t.status=:status")
    List<Task> findByStatus(String status);

    List<Task> findByUserIdAndStatus(int userId,  String status);

 /*   @Query("from Task t where t.userId=:userId and  t.status=:status")
    List<Task> findByUserIdStatus(@Param("userId") int userId, @Param("status") String status);*/

    @Query("from Task t where t.id BETWEEN  :start and :end")
    List<Task> findBetween(@Param("start") int start, @Param("end") int end);

}