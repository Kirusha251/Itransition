package net.ahramionok.model;

import javax.persistence.*;

/**
 * Created by KIrill on 07.01.2017.
 */
@Entity
@Table(name = "achievements_and_users", schema = "sitebuilder", catalog = "")
public class AchievementsAndUsers {
    private int idUser;
    private int idAchievement;
    private int id;

    @Basic
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_achievement", nullable = false)
    public int getIdAchievement() {
        return idAchievement;
    }

    public void setIdAchievement(int idAchievement) {
        this.idAchievement = idAchievement;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AchievementsAndUsers that = (AchievementsAndUsers) o;

        if (idUser != that.idUser) return false;
        if (idAchievement != that.idAchievement) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idAchievement;
        result = 31 * result + id;
        return result;
    }
}
