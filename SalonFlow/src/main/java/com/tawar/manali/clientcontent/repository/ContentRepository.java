package com.tawar.manali.clientcontent.repository;

import com.tawar.manali.clientcontent.model.Content;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.util.Date;
import java.util.List;


public interface ContentRepository extends ListCrudRepository<Content,Integer>{
    List<Content> findAllByNameContains(String keyword);

    @Query("""
        SELECT *FROM Content
        WHERE emailId=:emailId
""")
    List<Content> listByEmailId(@Param("emailId") String emailId);


    List<Content> findAllByDob(Date dob);
    @Query("""

            SELECT *FROM Content
            WHERE FORMATDATETIME(DOB,'MM') = :month and FORMATDATETIME(DOB,'dd') = :day
    """)
    List<Content> findAllByBirthday(int month, int day);

}
