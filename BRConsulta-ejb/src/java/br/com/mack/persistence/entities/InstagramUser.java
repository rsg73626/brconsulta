/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author 31595472
 */
@Entity
public class InstagramUser extends User{
    private long instagramId;
    @Transient
    private String profilePicture;
    @Transient
    private String accessToken;

    public InstagramUser() {
    
    }

    public InstagramUser(long instagramId, String profilePicture, String accessToken, String fullName, Date birthday, String email, String userName) {
        super(fullName, birthday, email, userName);
        this.instagramId = instagramId;
        this.profilePicture = profilePicture;
        this.accessToken = accessToken;
    }

    public long getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(long instagramId) {
        this.instagramId = instagramId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return super.toString() + "InstagramUser{" + "instagramId=" + instagramId + ", profilePicture=" + profilePicture + ", accessToken=" + accessToken + '}';
    }   
    
}
