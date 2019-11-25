package com.insight.learning.platabank.transferenceservice.mapper;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferenceMapper {

    TransferenceDTO toTransferenceDTO(Transference transference);
    Transference toTransference(TransferenceDTO transferenceDTO);

}
