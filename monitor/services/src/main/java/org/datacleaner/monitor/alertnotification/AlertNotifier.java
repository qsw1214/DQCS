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
package org.datacleaner.monitor.alertnotification;

import java.util.Map;

import org.datacleaner.monitor.configuration.ResultContext;
import org.datacleaner.monitor.scheduling.model.AlertDefinition;
import org.datacleaner.monitor.scheduling.model.ExecutionLog;
import java.util.function.Supplier;

/**
 * Interface for components that listen for executions and notifies in case any
 * alerts was raised..
 * 侦听执行并在出现任何警报时通知的组件的接口。
 */
public interface AlertNotifier {

    public void onExecutionFinished(ExecutionLog execution, Supplier<Map<AlertDefinition, Number>> activeAlerts,
                                    ResultContext result);
}
