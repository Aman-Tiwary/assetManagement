package com.case_study.Project2.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.case_study.Project2.models.Asset;;

@Repository
public interface AssetRepository extends MongoRepository<Asset,String>{

    List<Asset> findAllByOwner(String owner);

    List<Asset> findByOwnerId(String ownerId);

    void deleteAllById(String ownerId);

    void deleteAllByOwnerId(String id);  
}
