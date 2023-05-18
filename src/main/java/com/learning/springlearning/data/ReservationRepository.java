package com.learning.springlearning.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Iterable<Reservation> getReservationByReservationDate(Date date);
}
