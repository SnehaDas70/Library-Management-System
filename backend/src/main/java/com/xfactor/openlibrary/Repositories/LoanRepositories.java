package com.xfactor.openlibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Loan;

import java.util.List;

public interface LoanRepositories extends JpaRepository<Loan, Long> {

    List<Loan> findBybookId(Long bookId);

    List<Loan> findBystudentId(Long studentId);

    List<Loan> findBycheckoutDate(String checkoutDate);

    List<Loan> findBydueDate(String dueDate);

    List<Loan> findByreturnDate(String returnDate);
}
