package com.sandun.personal.project.model.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table
public class SandunLewke  implements Serializable {
	private static final long serialVersionUID = 1L;

    	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="profile_id")
	private Long profileId;
    	
    	@Version
	private Long version;
	
	private Boolean archived;

	private String firstname;

	private String surname;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String email;

	@Column(name="ethnicity_id")
	private Long ethnicityId;

	@Column(name="gender_id")
	private Long genderId;

	@Column(name="nhs_id")
	private String nhsId;

	@Column(name="nhs_number_status_indicator_code_id")
	private Long nhsNumberStatusIndicatorCodeId;

	private String partner;

	@Column(name="portal_access")
	private Boolean portalAccess;

	@Column(name="religion_id")
	private Long religionId;

	@Column(name="service_allocated_patient_id")
	private String serviceAllocatedPatientId;

	@Column(name="user_profile_id")
	private String userProfileId;

	@Column(name="username_id")
	private Long usernameId;

	public Long getProfileId() {
		return this.profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEthnicityId() {
		return this.ethnicityId;
	}

	public void setEthnicityId(Long ethnicityId) {
		this.ethnicityId = ethnicityId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getGenderId() {
		return this.genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getNhsId() {
		return this.nhsId;
	}

	public void setNhsId(String nhsId) {
		this.nhsId = nhsId;
	}

	public Long getNhsNumberStatusIndicatorCodeId() {
		return this.nhsNumberStatusIndicatorCodeId;
	}

	public void setNhsNumberStatusIndicatorCodeId(Long nhsNumberStatusIndicatorCodeId) {
		this.nhsNumberStatusIndicatorCodeId = nhsNumberStatusIndicatorCodeId;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Boolean getPortalAccess() {
		return this.portalAccess;
	}

	public void setPortalAccess(Boolean portalAccess) {
		this.portalAccess = portalAccess;
	}

	public Long getReligionId() {
		return this.religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public String getServiceAllocatedPatientId() {
		return this.serviceAllocatedPatientId;
	}

	public void setServiceAllocatedPatientId(String serviceAllocatedPatientId) {
		this.serviceAllocatedPatientId = serviceAllocatedPatientId;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserProfileId() {
		return this.userProfileId;
	}

	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Long getUsernameId() {
		return this.usernameId;
	}

	public void setUsernameId(Long usernameId) {
		this.usernameId = usernameId;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getArchived() {
	    return archived;
	}

	public void setArchived(Boolean archived) {
	    this.archived = archived;
	}

}
