package com.alexxstepan.taskmanagement;

import com.alexxstepan.taskmanagement.entities.TaskStatus;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;
import java.sql.*;

public class PsqlTaskStatusConverter extends EnumType {

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
		return TaskStatus.getByLabel(rs.getString(names[0]));
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
					((TaskStatus) value).getLabel(),
					Types.OTHER
			);
		}
	}
}
