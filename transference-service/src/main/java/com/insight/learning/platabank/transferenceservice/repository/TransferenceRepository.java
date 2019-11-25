package com.insight.learning.platabank.transferenceservice.repository;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import org.springframework.data.repository.Repository;

public interface TransferenceRepository extends Repository<Transference,Long> {

    Transference save(Transference transference);

}
