package com.case_study.Project2.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.convert.DbRefProxyHandler;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "TeamDetails")
public class TeamMember{
    @Id
    private String empid;
    private String employeeName;
  
    private List<Asset> personalAsset;
   
    private List<TeamAsset> teamAsset;

    public TeamMember (){}
    public TeamMember (String empid,String employeeName,List<Asset> personalAsset,List<TeamAsset> teamAsset)
    {
        this.empid=empid;
        this.employeeName=employeeName;
        this.personalAsset=personalAsset;
        this.teamAsset=teamAsset;
    }
    

    
    
}
