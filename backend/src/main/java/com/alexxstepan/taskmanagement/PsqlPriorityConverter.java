package com.alexxstepan.taskmanagement;

import com.alexxstepan.taskmanagement.entities.Priority;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PsqlPriorityConverter extends EnumType {

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
		return Priority.getByLabel(rs.getString(names[0]));
	}

	public void nullSafeSet(PreparedStatement st,
							Object value,
							int index,
							SharedSessionContractImplementor session) throws HibernateException, SQLException {
		if(value == null) {
			throw new IllegalArgumentException();
		}
		else {
			st.setObject(
					index,
					((Priority) value).getLabel(),
					Types.OTHER
			);
		}
	}
}
