package com.palettering.api.palettering.alarm.repository;

import com.palettering.api.palettering.alarm.domain.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
