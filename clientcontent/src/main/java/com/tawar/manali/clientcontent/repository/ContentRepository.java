package com.tawar.manali.clientcontent.repository;

import com.tawar.manali.clientcontent.model.Content;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ContentRepository extends ListCrudRepository<Content,Integer>{
    List<Content> findAllByNameContains(String keyword);

    @Query("""
        SELECT *FROM Content
        WHERE emailId=:emailId
""")
    List<Content> listByEmailId(@Param("emailId") String emailId);

}
