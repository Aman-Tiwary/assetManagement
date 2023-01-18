package com.case_study.Project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.case_study.Project2.models.Asset;
import com.case_study.Project2.models.TeamAsset;
import com.case_study.Project2.models.TeamMember;
import com.case_study.Project2.repositories.AssetRepository;
import com.case_study.Project2.repositories.TeamAssetRepository;
import com.case_study.Project2.repositories.TeamMemberRepository;


@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamMemberRepository teamRepository;
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private TeamAssetRepository teamAssetRepository;



    @PostMapping("/addMember")
    public TeamMember addMember(@RequestBody TeamMember teamMember)
    {
        return teamRepository.insert(teamMember);
    }

    @GetMapping("/getAll")
    public List<TeamMember> getTeamMembers()
    {
        return teamRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable String id,@RequestBody TeamMember teamMember)
    {
        teamRepository.deleteByEmpid(id);
        assetRepository.deleteAllByOwnerId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value ="/update/personalAssets/{ownerid}", method = RequestMethod.PATCH)
    public TeamMember updateTeamMemberPersonalAsset(@PathVariable String ownerid) {
        List<Asset> x = assetRepository.findByOwnerId(ownerid);
        TeamMember t = teamRepository.findByEmpid(ownerid);
        t.setPersonalAsset(x);
        teamRepository.save(t);
        return t;
    }

    @RequestMapping(value ="/update/teamAssets/{ownerid}", method = RequestMethod.PATCH)
    public TeamMember updateTeamMemberTeamAsset(@PathVariable String ownerid) {
        List<TeamAsset> x = teamAssetRepository.findByOwnerId(ownerid);
        TeamMember t = teamRepository.findByEmpid(ownerid);
        t.setTeamAsset(x);
        teamRepository.save(t);
        return t;
    }

}
