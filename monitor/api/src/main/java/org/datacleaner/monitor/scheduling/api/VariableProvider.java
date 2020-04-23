/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
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
package org.datacleaner.monitor.scheduling.api;

import java.util.Map;

import org.datacleaner.monitor.job.JobContext;
import org.datacleaner.monitor.scheduling.model.ExecutionLog;

/**
 * Defines a mechanism to provide variable values to the DataCleaner monitor
 * application at runtime.
 * 定义一种在运行时向DataCleaner Monitor应用程序提供变量值的机制。
 */
public interface VariableProvider {

    public Map<String, String> provideValues(JobContext job, ExecutionLog execution);
}
