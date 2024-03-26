package in.jewelx.jewelxbackend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * This entity records sale of particular item
 * */

@Getter
@Setter
@Entity
@Table(name = "sales")
public class SaleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx_id")
	private Long idxId;

	@Column(name = "sale_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID saleId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

//	@Column(name = "transaction_type", length = 2)
//	private String transactionType;
//
//	@Column(name = "payment_mode", length = 3, nullable = false)
//	private String paymentMode;

//	@Temporal(TemporalType.DATE)
//	@Column(name = "purchasing_date", nullable = false)
//	private Date purchasingDate;

//	@Temporal(TemporalType.DATE)
//	@Column(name = "due_date", nullable = false)
//	private Date dueDate;

	@Column(name = "sgst", precision = 8, scale = 2, nullable = false)
	private BigDecimal sgst;

	@Column(name = "cgst", precision = 8, scale = 2, nullable = false)
	private BigDecimal cgst;

	@Column(name = "total_making_charges", precision = 8, scale = 2, nullable = false)
	private BigDecimal totalMakingCharges;

	@Column(name = "discount", precision = 8, scale = 2, nullable = false)
	private BigDecimal discount;

	@Column(name = "net_amount", precision = 8, scale = 2, nullable = false)
	private BigDecimal netAmount;

	@Column(name = "payable_amount", precision = 8, scale = 2, nullable = false)
	private BigDecimal payableAmount;

	// transaction id of any online payment mode
//	@Column(name = "transaction_id", length = 50, unique = true)
//	private String transactionId;

//	@Column(name = "cash_payment", precision = 15, nullable = false)
//	private BigDecimal cashPayment;

//	@Column(name = "online_payment", precision = 15, nullable = false)
//	private BigDecimal onlinePayment;

//	@Column(name = "cheques_payment", precision = 8, nullable = false)
//	private BigDecimal chequesPayment;

//	@Column(name = "cheque_number", length = 255, nullable = false)
//	private String chequeNumber;

	@ManyToOne
	@JoinColumn(name = "subsidiary_id", nullable = false)
	private SubsidiaryEntity subsidiary;

	@ManyToOne
	@JoinColumn(name = "accounting_id", nullable = false)
	private AccountingEntity accounting;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private CustomerOrderEntity order;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false, updatable = false)
	private LocalDateTime createdOn;

	@UpdateTimestamp
	@Column(name = "updated_on", nullable = false)
	private LocalDateTime updatedOn;

	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false, updatable = false)
	private UserEntity createdBy;

	@ManyToOne
	@JoinColumn(name = "updated_by", nullable = false)
	private UserEntity updatedBy;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private BrandEntity brand;

	// Constructors, getters, and setters

	public SaleEntity() {
		// Default constructor
		this.saleId = UUID.randomUUID();
	}

	public SaleEntity(Long idxId) {
		super();
		this.idxId = idxId;
	}

}
