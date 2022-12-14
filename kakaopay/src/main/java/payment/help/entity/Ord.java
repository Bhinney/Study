package payment.help.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ord extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordId;

	@Column(length = 50, nullable = false)
	private String address;

	@Column(length = 13, nullable = false)
	private String phone;

	@Column
	private int quantity;

	@Column
	private int totalPrice;

	@Column
	private String tid;

	/* ๐์ํ - ์ฃผ๋ฌธ ์ผ๋์ผ ์ฐ๊ด ๊ด๊ณ : ์ํ ์ฐธ์กฐ */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column
	@Enumerated(EnumType.STRING)
	private OrdStatus status = OrdStatus.ORD_REQUEST;

	public enum OrdStatus {

		ORD_REQUEST(1, "์ฃผ๋ฌธ ์์ฒญ"),
		PAY_COMPLETE(2, "๊ฒฐ์  ์๋ฃ");

		@Getter
		private int number;
		@Getter
		private String description;

		OrdStatus(int number, String description) {
			this.number = number;
			this.description = description;
		}
	}
}

