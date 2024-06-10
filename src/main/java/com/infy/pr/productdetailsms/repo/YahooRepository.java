package com.infy.pr.productdetailsms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.pr.productdetailsms.model.YahooUser;

@Repository
public interface YahooRepository extends JpaRepository<YahooUser, Long> {
}
