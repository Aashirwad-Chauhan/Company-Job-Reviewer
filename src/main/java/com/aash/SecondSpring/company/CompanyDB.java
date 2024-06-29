package com.aash.SecondSpring.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDB extends JpaRepository<Company, Long> {
}
