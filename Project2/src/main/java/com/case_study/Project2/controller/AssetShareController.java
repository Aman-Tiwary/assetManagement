package com.case_study.Project2.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.case_study.Project2.models.AssetShare;
import com.case_study.Project2.models.TeamAsset;
import com.case_study.Project2.models.TeamMember;
import com.case_study.Project2.repositories.AssetShareRepository;
import com.case_study.Project2.repositories.TeamAssetRepository;
import com.case_study.Project2.repositories.TeamMemberRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/sharedAssets")
public class AssetShareController {
    @Autowired
    private AssetShareRepository assetShareRepository;
    @Autowired
    private TeamAssetRepository teamAssetRepository;
    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private TeamController teamController;

    @GetMapping("/getAssetShared")
    public List<AssetShare> getAsset()
    {
        return assetShareRepository.findAll();
    }

    @Transactional
    @PatchMapping("/ShareAsset/{empid}/{id}")
    public AssetShare addAssetToMember(@PathVariable String id,@PathVariable String empid,@RequestBody AssetShare assetShare)
    {
        Optional<TeamAsset> t = teamAssetRepository.findById(id); 
        TeamMember teamMember = teamMemberRepository.findByEmpid(empid);
        if(t.get().isAvailable())
        {
            String name = t.get().getAssetName();
            String memberName = teamMember.getEmployeeName();
            assetShare.setAssetId(id);
            assetShare.setAssetName(name);
            assetShare.setAssignedTo(empid);
            assetShare.setType("debit");
            assetShare.setDate(new Date());
            t.get().setOwner(memberName);
            t.get().setOwnerId(empid);
            t.get().setAvailable(false); 
        }
        //teamMember.setTeamAsset(ta);
        teamAssetRepository.save(t.get());
        //teamMemberRepository.save(teamMember);
        assetShareRepository.insert(assetShare);
        teamController.updateTeamMemberTeamAsset(empid);
        return assetShare;
    }

    @Transactional
    @PatchMapping("/ReleaseAsset/{id}")
    public AssetShare releaseAsset(@PathVariable String id,@RequestBody AssetShare assetShare)
    {
        Optional<TeamAsset> t = teamAssetRepository.findById(id); 
        String empid =t.get().getOwnerId();
        assetShare.setAssetId(id);
        assetShare.setAssetName(t.get().getAssetName());
        assetShare.setAssignedTo("");
        assetShare.setType("credit");
        assetShare.setDate(new Date());
        t.get().setOwner("");
        t.get().setOwnerId("");
        t.get().setAvailable(true);

        teamAssetRepository.save(t.get());
        assetShareRepository.insert(assetShare);
        teamController.updateTeamMemberTeamAsset(empid);
        return assetShare;
    }
    
}
