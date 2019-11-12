package com.insight.learning.platabank.transferenceservice.mapper;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TransferenceMapper {

    TransferenceDTO toTransferenceDTO(Transference transference);

}
