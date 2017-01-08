package net.ahramionok.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KIrill on 07.01.2017.
 */
@Entity
public class Site {
    private int idSite;
    private String siteName;
    private String description;
    private String menuType;
    private String content;
    private Integer idOwner;
    private Integer template;

    @Id
    @Column(name = "id_site", nullable = false)
    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    @Basic
    @Column(name = "site_name", nullable = true, length = 50)
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "menu_type", nullable = true, length = 50)
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "id_owner", nullable = true)
    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

    @Basic
    @Column(name = "template", nullable = true)
    public Integer getTemplate() {
        return template;
    }

    public void setTemplate(Integer template) {
        this.template = template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (idSite != site.idSite) return false;
        if (siteName != null ? !siteName.equals(site.siteName) : site.siteName != null) return false;
        if (description != null ? !description.equals(site.description) : site.description != null) return false;
        if (menuType != null ? !menuType.equals(site.menuType) : site.menuType != null) return false;
        if (content != null ? !content.equals(site.content) : site.content != null) return false;
        if (idOwner != null ? !idOwner.equals(site.idOwner) : site.idOwner != null) return false;
        if (template != null ? !template.equals(site.template) : site.template != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSite;
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (menuType != null ? menuType.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (idOwner != null ? idOwner.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        return result;
    }
}
