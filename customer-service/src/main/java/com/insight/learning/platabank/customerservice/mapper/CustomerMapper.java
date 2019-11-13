package com.insight.learning.platabank.customerservice.mapper;

import com.insight.learning.platabank.customerservice.domain.Address;
import com.insight.learning.platabank.customerservice.domain.Career;
import com.insight.learning.platabank.customerservice.domain.ContactPhone;
import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.dto.AddressDTO;
import com.insight.learning.platabank.customerservice.dto.CareerDTO;
import com.insight.learning.platabank.customerservice.dto.ContactPhoneDTO;
import com.insight.learning.platabank.customerservice.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toCustomerDTO(Customer customer);

    Customer toCustomer(CustomerDTO customerDTO);

    AddressDTO toAddressDTO(Address address);

    Address toAddress(AddressDTO addressDTO);

    ContactPhoneDTO toContactPhoneDTO(ContactPhone contactPhone);

    ContactPhone toContactPhone(ContactPhoneDTO contactPhoneDTO);

    CareerDTO toCareerDTO(Career career);

    Career toCareer(CareerDTO careerDTO);

}
