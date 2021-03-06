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
package org.datacleaner.documentation;

import org.apache.metamodel.util.HasName;
import org.datacleaner.api.Description;
import org.datacleaner.api.Filter;
import org.datacleaner.util.ReflectionUtils;

/**
 * A wrapper around a {@link Filter}s outcome object to make it easier for the
 * documentation template to get to certain aspects that should be presented in
 * the documentation.
 * {@link Filter}的结果对象周围的包装器，使文档模板可以更轻松地到达应在文档中提供的某些方面。
 */
public class FilterOutcomeDocumentationWrapper {

    private final Enum<?> _outcome;

    public FilterOutcomeDocumentationWrapper(final Enum<?> outcome) {
        _outcome = outcome;
    }

    public String getName() {
        if (_outcome instanceof HasName) {
            return ((HasName) _outcome).getName();
        }
        return _outcome.toString();
    }

    public String getDescription() {
        final Description annotation = ReflectionUtils.getAnnotation(_outcome, Description.class);
        if (annotation == null) {
            return "";
        }

        final String description = annotation.value();
        return DocumentationUtils.createHtmlParagraphs(description);
    }
}
