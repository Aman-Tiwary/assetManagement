package com.case_study.Project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.case_study.Project2.models.Asset;
import com.case_study.Project2.repositories.AssetRepository;
import com.case_study.Project2.repositories.TeamMemberRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private TeamMemberRepository teamRepository;
    @Autowired
    private TeamController teamController;

    @PostMapping("/add-asset")
    public Asset addAsset(@RequestBody Asset asset)
    {
        String ownerId = asset.getOwnerId();
        assetRepository.save(asset);
        teamController.updateTeamMemberPersonalAsset(ownerId);
        return asset ;
    }

    @GetMapping("/getAllAssets")
    public List<Asset> getAsset()
    {
        return assetRepository.findAll();
    }

    @GetMapping("/findAssetBy/{owner}")
    public List<Asset> getAsset(@PathVariable("owner") String owner)
    {
        return assetRepository.findAllByOwner(owner);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable String id)
    {
        assetRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
