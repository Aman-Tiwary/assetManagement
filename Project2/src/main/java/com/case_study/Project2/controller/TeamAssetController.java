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

import com.case_study.Project2.models.TeamAsset;
import com.case_study.Project2.repositories.TeamAssetRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/teamAssets")
public class TeamAssetController {
    @Autowired
    private TeamAssetRepository teamAssetRepository;

    @PostMapping("/add")
    public TeamAsset addTeamAsset(@RequestBody TeamAsset teamAsset)
    {
        return teamAssetRepository.insert(teamAsset);
    }

    @GetMapping("/getAll")
    public List<TeamAsset> getTeamAsset()
    {
        return teamAssetRepository.findAll();
    }

    @GetMapping("/find/{owner}")
    public List<TeamAsset> getTeamAsset(@PathVariable("owner") String owner)
    {
        return teamAssetRepository.findAllByOwner(owner);
    } 

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable String id,@RequestBody TeamAsset teamAsset)
    {
        teamAssetRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
