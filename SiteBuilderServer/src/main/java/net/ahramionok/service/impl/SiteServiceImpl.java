package net.ahramionok.service.impl;

import net.ahramionok.model.Site;
import net.ahramionok.repository.SiteRepository;
import net.ahramionok.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteRepository siteRepository;
    @Override
    public Site findByIdSite(Integer idSite) {
        return siteRepository.findByIdSite(idSite);
    }

    @Override
    public Site findBySiteName(String siteName) {
        return siteRepository.findBySiteName(siteName);
    }

    @Override
    public Site findByIdOwner(Integer idOwner) {
        return siteRepository.findByIdOwner(idOwner);
    }

    @Override
    public Collection<Site> findAllByIdOwner(Integer idOwner) {
        return siteRepository.findAllByIdOwner(idOwner);
    }


    @Override
    public Collection<Site> findAll() {
        return siteRepository.findAll();
    }

    @Override
    public void save(Site site) {
        siteRepository.save(site);
    }

    @Override
    public void deleteByIdSite(Integer idSite) {
        siteRepository.deleteByIdSite(idSite);
    }
}
