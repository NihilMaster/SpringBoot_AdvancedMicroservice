package zzz.master.loans.domain.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LoanModel {

    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatusEnum status;
    private Integer renewalCount; // Número de veces que se ha renovado el préstamo
    private BigDecimal fineAmount; // Monto de multa

}
