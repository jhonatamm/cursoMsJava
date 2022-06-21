package com.medinastech.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medinastech.hrworker.Worker.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
