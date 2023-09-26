package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Info;
import com.lamell.padelkarin.services.InfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class InfoController {

    @Autowired
    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    private static final Logger logger = LogManager.getLogger(InfoService.class);

    @GetMapping("/infotext")
    public List<Info> getAllInfos() {
        return infoService.getAllInfos();
    }

    @PutMapping("/updateinfotext")
    public ResponseEntity<Info> updateInfo(@RequestBody Info info){
        logger.info("Admin updated infotext");
        return ResponseEntity.ok(infoService.updateInfo(info, info.getInfoId()));
    }
}
