package com.cyu.laclad.web.commands;

import java.util.Date;

import com.cyu.laclad.domain.Company;
import com.cyu.laclad.domain.Representant;
import com.cyu.laclad.enums.Status;

public class CompanyCommand {

	private Long id;
	private String juridicName;
    private Representant legalRepresentant;
    private Date enroldDate;
    private Long personalId;
    private String name;
    private Status status;
    private Integer Version;
	
    public CompanyCommand() {
		super();
	}

    public CompanyCommand(Company company) {    	
		super();
		this.id = company.getId();
		this.personalId = company.getPersonalId();
		this.juridicName = company.getJuridicName();
		this.legalRepresentant = company.getLegalRepresentant();
		this.enroldDate = company.getEnroldDate();
		this.name = company.getName();
		this.status = company.getStatus();
		this.Version = company.getVersion();
	}

    public Company initCompany() {
    	Company company = new Company();
    	
    	company.setId(this.id);
    	company.setPersonalId(this.personalId);
    	company.setJuridicName(this.juridicName);
    	company.setLegalRepresentant(this.legalRepresentant);
    	company.setEnroldDate(new Date());
    	company.setName(this.name);
    	company.setStatus(this.status);
    	company.setVersion(this.Version);
    	
    	return company;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJuridicName() {
		return juridicName;
	}

	public void setJuridicName(String juridicName) {
		this.juridicName = juridicName;
	}

	public Representant getLegalRepresentant() {
		return legalRepresentant;
	}

	public void setLegalRepresentant(Representant legalRepresentant) {
		this.legalRepresentant = legalRepresentant;
	}

	public Date getEnroldDate() {
		return enroldDate;
	}

	public void setEnroldDate(Date enroldDate) {
		this.enroldDate = enroldDate;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getVersion() {
		return Version;
	}

	public void setVersion(Integer version) {
		Version = version;
	}
}