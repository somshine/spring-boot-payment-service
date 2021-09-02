package com.somshine.paymentService.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.somshine.paymentService.model.Company;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	@Query("SELECT com FROM Company com WHERE deleted = 0 ORDER BY id ASC")
    List<Company> findCompanyAscSorting();
	
	
	@Query("SELECT com FROM Company com")
    List<Company> getAllCompanyBySql();
	
	Company findByName(String name);
}
