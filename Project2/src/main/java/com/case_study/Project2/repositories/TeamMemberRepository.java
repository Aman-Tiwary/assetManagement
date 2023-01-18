package com.case_study.Project2.repositories;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.case_study.Project2.models.TeamMember;

@Repository
public interface TeamMemberRepository extends MongoRepository<TeamMember,String>{

    TeamMember findByEmpid(String id);

    void deleteByEmpid(String id);
    
}
