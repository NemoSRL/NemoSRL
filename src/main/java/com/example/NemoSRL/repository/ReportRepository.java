package com.example.NemoSRL.repository;

import com.example.NemoSRL.model.Report;
import com.example.NemoSRL.model.ReportId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, ReportId> {
}