/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2013, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.engine.jdbc.dialect.spi;

import java.sql.DatabaseMetaData;

import org.hibernate.dialect.Dialect;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.service.Service;

/**
 * Contract for determining the {@link Dialect} to use based on a JDBC {@link java.sql.Connection}.
 *
 * @author Tomoto Shimizu Washio
 * @author Steve Ebersole
 */
public interface DatabaseMetaDataDialectResolver extends Service {
	/**
	 * Determine the {@link org.hibernate.dialect.Dialect} to use based on the given JDBC {@link java.sql.DatabaseMetaData}.  Implementations are
	 * expected to return the {@link org.hibernate.dialect.Dialect} instance to use, or null if the {@link java.sql.DatabaseMetaData} does not match
	 * the criteria handled by this impl.
	 *
	 * @param metaData The JDBC metadata.
	 *
	 * @return The dialect to use, or null.
	 *
	 * @throws org.hibernate.exception.JDBCConnectionException Indicates a 'non transient connection problem', which indicates that
	 * we should stop resolution attempts.
	 */
	public Dialect resolveDialect(DatabaseMetaData metaData) throws JDBCConnectionException;
}
