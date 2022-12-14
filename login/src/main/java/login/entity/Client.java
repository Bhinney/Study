package login.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;

	/* πμλΉμ - νμ μΌλμΌ μ°κ΄ κ΄κ³ : νμ μ°Έμ‘°*/
	@OneToOne
	@JoinColumn(name = "member_id")
	private Member member;

	/* πμλΉμ - νμ μ°κ΄ κ΄κ³ νΈμ λ©μλ */
	public void setMember(Member member) {
		this.member = member;

		if (member.getClient() != this) {
			member.setClient(this);
		}
	}
}

