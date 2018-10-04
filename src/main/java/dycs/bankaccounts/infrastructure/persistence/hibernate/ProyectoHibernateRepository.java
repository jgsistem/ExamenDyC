package dycs.bankaccounts.infrastructure.persistence.hibernate;

import java.sql.SQLException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import dycs.bankaccounts.domain.entity.Proyecto;
import dycs.bankaccounts.domain.repository.ProyectoRepository;
import dycs.common.infrastructure.persistence.hibernate.BaseHibernateRepository;


@Transactional(rollbackOn=Exception.class)
@Repository
public class ProyectoHibernateRepository extends BaseHibernateRepository<Proyecto> implements ProyectoRepository {

	public ProyectoHibernateRepository() {
		super(Proyecto.class);
		// TODO Auto-generated constructor stub
	}

	

}
