package net.ahramionok.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KIrill on 07.01.2017.
 */
@Entity
public class Template {
    private int idTemplate;
    private String templateType;
    private String content;

    @Id
    @Column(name = "id_template", nullable = false)
    public int getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(int idTemplate) {
        this.idTemplate = idTemplate;
    }

    @Basic
    @Column(name = "template_type", nullable = true, length = 50)
    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (idTemplate != template.idTemplate) return false;
        if (templateType != null ? !templateType.equals(template.templateType) : template.templateType != null)
            return false;
        if (content != null ? !content.equals(template.content) : template.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTemplate;
        result = 31 * result + (templateType != null ? templateType.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
