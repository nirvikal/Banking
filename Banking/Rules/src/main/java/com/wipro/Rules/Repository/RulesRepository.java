package com.wipro.Rules.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Rules.Model.RuleStatus;

@Repository
public interface RulesRepository extends JpaRepository<RuleStatus,Long>{

}
