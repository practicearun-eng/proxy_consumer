package com.ex.test.proxy_consumer.repository;

import com.ex.test.proxy_consumer.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> { }