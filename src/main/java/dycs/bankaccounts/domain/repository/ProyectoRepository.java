package dycs.bankaccounts.domain.repository;

import java.sql.SQLException;

import dycs.bankaccounts.domain.entity.Proyecto;

public interface ProyectoRepository {
	public void create(Proyecto proyecto) throws SQLException;
	public void delete(Proyecto proyecto) throws SQLException;
	public Proyecto read(long id) throws SQLException;

}
