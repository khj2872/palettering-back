package com.palettering.api.palettering.report.repository;

import com.palettering.api.palettering.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
