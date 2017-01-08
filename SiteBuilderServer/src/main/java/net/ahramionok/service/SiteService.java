package net.ahramionok.service;

import net.ahramionok.model.Site;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface SiteService {
    Site findByIdSite(Integer idSite);
    Site findBySiteName(String siteName);
    Site findByIdOwner(Integer idOwner);
    Collection<Site> findAllByIdOwner(Integer idOwner);
    Collection<Site> findAll();
    void save(Site site);
    void deleteByIdSite(Integer idSite);
}
