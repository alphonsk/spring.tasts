package com.example.task.service.impl;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        LocalDate myDate = task.getTaskDate();
        Boolean checkDate = validateJavaDate(myDate.toString());

        if (true) {
            return taskRepository.save(task);
        } else {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate text = LocalDate.from(LocalDate.parse(date.format(formatter)));
            task.setTaskDate(text);
            return taskRepository.save(task);
        }

//        return
    }

    @Override
    public Boolean delete(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public List<Task> findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> findByUserIdStatus(int userId, String status) {
        //return  taskRepository.findByUserIdStatus(userId, status);
        return  taskRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<Task> findBetween(int start, int end) {
        return taskRepository.findBetween(start, end);
    }


    //    date format
    public static boolean validateJavaDate(String strDate)
    {
        /* Check if date is 'null' */
        if (strDate.trim().equals(""))
        {
            return true;
        }
        /* Date is not 'null' */
        else
        {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try
            {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate+" is valid date format");
            }
            /* Date format is invalid */
            catch (ParseException e)
            {
                System.out.println(strDate+" is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }




    // end
}
