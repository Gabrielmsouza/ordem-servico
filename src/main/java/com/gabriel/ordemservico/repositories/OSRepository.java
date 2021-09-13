package com.gabriel.ordemservico.repositories;

import com.gabriel.ordemservico.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS,Integer> {

}
