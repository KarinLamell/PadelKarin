package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;
import com.lamell.padelkarin.model.Info;
import com.lamell.padelkarin.repositories.InfoRepository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("info")
@Service
public class InfoService implements InfoServiceInterface {

    @Autowired
    private InfoRepository infoRepository;

    //private static final Logger logger = LogManager.getLogger(InfoService.class);

    @Override
    public Info saveInfo(Info info) {
        return infoRepository.save(info);
    }

    @Override
    public List<Info> getAllInfos() {
        return infoRepository.findAll();
    }

    @Override
    public Info updateInfo(Info info, int infoId) {
        Info i = infoRepository.findById(infoId).orElseThrow(()->new ResourceNotFoundException("Info", "Id", info));
        i.setInfotext(info.getInfotext());
        infoRepository.save(i);
        return i;
    }

    @Override
    public void deleteInfo(int infoId) {

        infoRepository.findById(infoId).orElseThrow(()->new ResourceNotFoundException("Info", "Id", infoId));
        infoRepository.deleteById(infoId);
    }

}
