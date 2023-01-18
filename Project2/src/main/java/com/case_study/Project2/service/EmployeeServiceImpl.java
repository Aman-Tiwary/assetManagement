package com.case_study.Project2.service;


import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.case_study.Project2.models.TeamMember;
import com.case_study.Project2.repositories.TeamMemberRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.client.result.UpdateResult;

@Service
public class EmployeeServiceImpl implements EmployeeService {


@Autowired
private TeamMemberRepository teamRepository;
    @Override
    public void insert(TeamMember teamMember) {
        teamRepository.insert(teamMember);
    }
    @Override
    public void save(TeamMember teamMember)
    {
        
        teamRepository.save(teamMember);
    }
    
    
}
