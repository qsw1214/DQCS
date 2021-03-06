/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
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
package org.datacleaner.cluster;

import org.datacleaner.job.AnalysisJob;

/**
 * Component responsible for determining how many divisions/chunks to build from
 * a single master job. Each division will be represented by a slave job.
 * 负责确定单个主任务要建立多少个部门/块的组件。每个部门将由一个奴隶工作代表。
 *
 * Too many divisions will cause too much distribution, i.e. units of work being
 * too small and time is wasted in distribution instead of execution.
 * 太多的部门将导致太多的分配，即工作单元太小，分配而不是执行浪费了时间。
 *
 * Too few divisions will cause potential bottleneck situations because the
 * slowest execution nodes will be determining the total job execution time.
 * 分区太少将导致潜在的瓶颈情况，因为最慢的执行节点将确定总的作业执行时间。
 */
public interface JobDivisionManager {

    int calculateDivisionCount(AnalysisJob masterJob, int expectedRows);

}
