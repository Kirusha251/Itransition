package net.ahramionok.repository;

import net.ahramionok.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface SiteRepository extends JpaRepository<Site,Integer> {
    Site findByIdSite(Integer idSite);
    Site findBySiteName(String siteName);
    Site findByIdOwner(Integer idOwner);
    Collection<Site> findAllByIdOwner(Integer idOwner);

    @Transactional
    void deleteByIdSite(Integer idSite);

}
