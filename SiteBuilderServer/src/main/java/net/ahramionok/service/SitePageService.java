package net.ahramionok.service;

import net.ahramionok.model.SitePage;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface SitePageService {
    SitePage findByIdPage(Integer idPage);
    Collection<SitePage> findAllByIdSite(Integer idSite);
    Collection<SitePage> findAll();
    void save(SitePage sitePage);
    void deleteByIdPage(Integer idPage);
}
