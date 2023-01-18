package com.case_study.Project2.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection = "TeamAsset")
public class TeamAsset {
    @Id
    private String id;
    private String assetName;
    private String category;
    private String owner;
    private String ownerId;
    private boolean isAvailable=true;
    


    public TeamAsset(){}
    public TeamAsset (String id,String assetName,String category,String owner,boolean isAvailable,String ownerId)
    {
        this.id=id;
        this.assetName=assetName;
        this.category=category;
        this.owner=owner;
        this.ownerId=ownerId;
        this.isAvailable=isAvailable;
        

    }
    
}
