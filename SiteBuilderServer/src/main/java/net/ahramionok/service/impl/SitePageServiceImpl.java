package net.ahramionok.service.impl;

import net.ahramionok.model.SitePage;
import net.ahramionok.repository.SitePageRepository;
import net.ahramionok.service.SitePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
@Service
public class SitePageServiceImpl implements SitePageService {

    @Autowired
    private SitePageRepository sitePageRepository;

    @Override
    public SitePage findByIdPage(Integer idPage) {
        return sitePageRepository.findByIdPage(idPage);
    }

    @Override
    public Collection<SitePage> findAllByIdSite(Integer idSite) {
        return sitePageRepository.findAllByIdSite(idSite);
    }

    @Override
    public Collection<SitePage> findAll() {
        return sitePageRepository.findAll();
    }

    @Override
    public void save(SitePage sitePage) {
        sitePageRepository.save(sitePage);
    }

    @Override
    public void deleteByIdPage(Integer idPage) {
        sitePageRepository.deleteByIdPage(idPage);
    }
}
