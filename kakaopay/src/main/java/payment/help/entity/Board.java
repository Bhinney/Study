package payment.help.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "board")
public class Board extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;

	@Column(length = 100, nullable = false)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false )
	private int reviewNum;

	@Column(nullable = false)
	private double reviewAvg ;

	/* πκ²μν - μν μΌλμΌ μ°κ΄ κ΄κ³ : μν μ°Έμ‘°*/
	@OneToOne
	@JoinColumn(name = "productId" , referencedColumnName = "productId")
	private Product product;

	/* πκ²μν - μν μ°κ΄ κ΄κ³ νΈμ λ©μλ */
	public void setBoard(Product product) {
		this.product = product;

		if (product.getBoard() != this) {
			product.setBoard(this);
		}
	}
}
