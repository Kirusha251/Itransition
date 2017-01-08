package net.ahramionok.model;

import javax.persistence.*;

/**
 * Created by KIrill on 07.01.2017.
 */
@Entity
@Table(name = "site_page", schema = "sitebuilder", catalog = "")
public class SitePage {
    private int idPage;
    private String pageContent;
    private int pagePosition;
    private Integer idSite;

    @Id
    @Column(name = "id_page", nullable = false)
    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    @Basic
    @Column(name = "page_content", nullable = false, length = -1)
    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    @Basic
    @Column(name = "page_position", nullable = false)
    public int getPagePosition() {
        return pagePosition;
    }

    public void setPagePosition(int pagePosition) {
        this.pagePosition = pagePosition;
    }

    @Basic
    @Column(name = "id_site", nullable = true)
    public Integer getIdSite() {
        return idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SitePage sitePage = (SitePage) o;

        if (idPage != sitePage.idPage) return false;
        if (pagePosition != sitePage.pagePosition) return false;
        if (pageContent != null ? !pageContent.equals(sitePage.pageContent) : sitePage.pageContent != null)
            return false;
        if (idSite != null ? !idSite.equals(sitePage.idSite) : sitePage.idSite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPage;
        result = 31 * result + (pageContent != null ? pageContent.hashCode() : 0);
        result = 31 * result + pagePosition;
        result = 31 * result + (idSite != null ? idSite.hashCode() : 0);
        return result;
    }
}
