package net.ahramionok.repository;

import net.ahramionok.model.SitePage;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface SitePageRepository extends JpaRepository<SitePage,Integer> {
    SitePage findByIdPage(Integer idPage);
    Collection<SitePage> findAllByIdSite(Integer idSite);

    @Transactional
    void deleteByIdPage(Integer idPage);
}
