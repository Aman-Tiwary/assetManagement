package com.case_study.Project2.models;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection = "PersonalAsset")
public class Asset implements Serializable{
    @Id
    private String id;
    private String assetName;
    private String category;
    private String owner;
    private String ownerId;

public Asset(){}

    public Asset (String id,String assetName,String category,String owner,String ownerId)
    {
        this.id=id;
        this.assetName=assetName;
        this.category=category;
        this.owner=owner;
        this.ownerId=ownerId;
    }
    
}
