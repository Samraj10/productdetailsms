package com.infy.pr.mf_second.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.pr.mf_second.model.YahooUser;

@Repository
public interface YahooRepository extends JpaRepository<YahooUser, Long> {
}
