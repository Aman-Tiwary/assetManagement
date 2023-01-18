package com.case_study.Project2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.case_study.Project2.models.AssetShare;

public interface AssetShareRepository extends MongoRepository<AssetShare,String>{

    
}
