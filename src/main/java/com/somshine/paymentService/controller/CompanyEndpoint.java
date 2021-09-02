package com.somshine.paymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.somshine.paymentService.gs_producing_web_service.GetCompaniesRequest;
import com.somshine.paymentService.gs_producing_web_service.GetCompaniesResponse;
import com.somshine.paymentService.gs_producing_web_service.GetCompanyRequest;
import com.somshine.paymentService.gs_producing_web_service.GetCompanyResponse;
import com.somshine.paymentService.model.Company;
import com.somshine.paymentService.repository.CompanyRepository;

@Endpoint
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin
public class CompanyEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompanyRequest")
	@ResponsePayload
	public GetCompanyResponse getCompany(@RequestPayload GetCompanyRequest request) {
		GetCompanyResponse companyResponse = new GetCompanyResponse();
		Company company = companyRepository.findByName(request.getName());
		com.somshine.paymentService.gs_producing_web_service.Company wsCompany = new com.somshine.paymentService.gs_producing_web_service.Company();
		if (company != null) {
			wsCompany.setDescription(company.getDescription());
			wsCompany.setName(company.getName());
			wsCompany.setShoppeId(company.getShoppeId());
			wsCompany.setId(Integer.parseInt(company.getId() + ""));
		}
		companyResponse.setCompany(wsCompany);
		
		return companyResponse;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompaniesRequest")
	@ResponsePayload
	public GetCompaniesResponse getCompanies(@RequestPayload GetCompaniesRequest request) {
		GetCompaniesResponse companiesResponse = new GetCompaniesResponse();
		companiesResponse.setCompanies(companyRepository.findAll());
		
		return companiesResponse;
	}
	
}