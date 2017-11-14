package com.sprthyme.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "license")
public class LicenseModel {
	
	private String companyCode;
	private String  locnCode;
	private String serial;
	private int licsCount;
	private int actLicense;
	private int onlineMachines;
	private String type;
	private boolean typeFlag;

}
