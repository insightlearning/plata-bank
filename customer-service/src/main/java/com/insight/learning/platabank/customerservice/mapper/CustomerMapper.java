package com.insight.learning.platabank.customerservice.mapper;

import com.insight.learning.platabank.customerservice.domain.Address;
import com.insight.learning.platabank.customerservice.domain.Career;
import com.insight.learning.platabank.customerservice.domain.ContactPhone;
import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.dto.AddressDto;
import com.insight.learning.platabank.customerservice.dto.CareerDto;
import com.insight.learning.platabank.customerservice.dto.ContactPhoneDto;
import com.insight.learning.platabank.customerservice.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toCustomerDto(Customer customer);

    Customer toCustomer(CustomerDto customer);

    AddressDto toAddressDto(Address address);

    Address toAddress(AddressDto addressDto);

    ContactPhoneDto toContactPhoneDto(ContactPhone contactPhone);

    ContactPhone toContactPhone(ContactPhoneDto contactPhone);

    CareerDto toCareerDto(Career career);

    Career toCareer(CareerDto careerDto);

}
