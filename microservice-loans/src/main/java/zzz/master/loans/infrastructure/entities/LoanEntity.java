package zzz.master.loans.infrastructure.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import zzz.master.loans.domain.models.LoanStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table("loans")
public class LoanEntity {

    @Id
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("book_id")
    private Long bookId;

    @Column("loan_date")
    private LocalDate loanDate;

    @Column("due_date")
    private LocalDate dueDate;

    @Column("return_date")
    private LocalDate returnDate;
    private LoanStatusEnum status;

    @Column("renewal_count")
    private Integer renewalCount; // Número de veces que se ha renovado el préstamo

    @Column("fine_amount")
    private BigDecimal fineAmount; // Monto de multa
}
