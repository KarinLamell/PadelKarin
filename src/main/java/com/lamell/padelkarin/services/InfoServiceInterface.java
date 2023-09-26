package com.lamell.padelkarin.services;

import com.lamell.padelkarin.model.Info;

import java.util.List;

public interface InfoServiceInterface {

    Info saveInfo(Info info);

    List<Info> getAllInfos();

    Info updateInfo(Info info, int infoId);

    void deleteInfo(int infoId);
}
