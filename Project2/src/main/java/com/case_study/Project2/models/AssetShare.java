package com.case_study.Project2.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "SharedAssetDetail")
public class AssetShare {
    @Id
    private String shareId;
    private String assetName;
    private String assetId;
    private String assignedTo;
    private String type;
    private Date date;

    public AssetShare (String shareId,String assetName,String assetId,String assignedTo,String type,Date date)
    {
        this.shareId=shareId;
        this.assetName=assetName;
        this.assetId=assetId;
        this.assignedTo=assignedTo;
        this.type=type;
        this.date=date;
    }

    
}
