package com.spring.mvc.service;

import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dto.AddressDTO;
import com.spring.mvc.dto.CustomerDTO;
import com.spring.mvc.model.AddressEntity;
import com.spring.mvc.model.CustomerEntity;
import com.spring.mvc.model.MessageTransaction;
import com.spring.mvc.repository.AddressRepository;
import com.spring.mvc.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerEntity select(String id) {
		return customerRepository.getOne(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void create(Object entity) throws Exception {
		CustomerEntity customer = getCustomer((CustomerDTO) entity);
		Date now = new Date();
		String customerId = UUID.randomUUID().toString();
		customer.setId(customerId);
		customer.setCreateDay(now);
		customer.setUpdateDay(now);
		customerRepository.save(customer);
		//Save customer
		List<AddressEntity> listAddress = getAddress((CustomerDTO) entity);
		for(AddressEntity address : listAddress) {
			address.setId(UUID.randomUUID().toString());
			address.setCustomerId(customerId);
			addressRepository.save(address);
			if(address.getName().equals("exception")) {
				throw new SQLException();
			}
		}
	}

	@Override
	public CustomerEntity getCustomerByName(String name) {
		List<CustomerEntity> list = customerRepository.findByName(name);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean checkExistsName(String name) {
		return customerRepository.findByName(name).size() > 0;
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}

	private CustomerEntity getCustomer(CustomerDTO entity) {
		CustomerEntity customer = new CustomerEntity();
		customer = modelMapper.map(entity, CustomerEntity.class);
		return customer;
	}

	private List<AddressEntity> getAddress(CustomerDTO entity) {
		List<AddressDTO> listAddressDTO = entity.getListAddress();
		List<AddressEntity> list = new ArrayList<AddressEntity>();
		for(int i = 0; i < listAddressDTO.size(); i++) {
			AddressEntity address = new AddressEntity();
			address.setName(listAddressDTO.get(i).getName());
			list.add(address);
		}
		return list;
	}

	@Override
	public Flux<MessageTransaction> getCustomerFlux() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        //interval.subscribe((i) -> stockList.forEach(stock -> stock.setPrice(changePrice(stock.getPrice()))));
        Flux<MessageTransaction> stockTransactionFlux = Flux.fromStream(Stream.generate(() -> new MessageTransaction("", "", new Date())));
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
	}

}
