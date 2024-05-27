package com.infy.pr.mf_second.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.pr.mf_second.model.GmailUser;

@Repository
public interface GmailRepository extends JpaRepository<GmailUser, Long> {
}
