package com.case_study.Project2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.case_study.Project2.models.TeamAsset;

public interface TeamAssetRepository  extends MongoRepository<TeamAsset,String>{
    List<TeamAsset> findAllByOwner(String owner);

    List<TeamAsset> findByOwnerId(String ownerid);  
}
