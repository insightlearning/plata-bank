package com.insight.learning.platabank.transferenceservice.service;

import com.insight.learning.platabank.transferenceservice.domain.Transference;

import java.util.Optional;

public abstract class TransferenceService {

    public abstract Optional<Transference> doTransference(Transference transference);

}
