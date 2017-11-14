package com.sprthyme.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "license-list")
public class LicenseList {
	
	private List<LicenseModel> licenses;

}
