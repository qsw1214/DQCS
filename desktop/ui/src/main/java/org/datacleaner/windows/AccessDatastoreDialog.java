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
package org.datacleaner.windows;

import javax.inject.Inject;
import javax.swing.filechooser.FileFilter;

import org.datacleaner.bootstrap.WindowContext;
import org.datacleaner.connection.AccessDatastore;
import org.datacleaner.guice.Nullable;
import org.datacleaner.user.MutableDatastoreCatalog;
import org.datacleaner.user.UserPreferences;
import org.datacleaner.util.FileFilters;
import org.datacleaner.util.IconUtils;
import org.datacleaner.widgets.AbstractResourceTextField;

/**
 * Datastore configuration dialog for MS Access datastores.
 * MS Access数据存储的数据存储配置对话框。
 *
 * @author Kasper Sørensen
 */
public final class AccessDatastoreDialog extends AbstractFileBasedDatastoreDialog<AccessDatastore> {

    private static final long serialVersionUID = 1L;

    @Inject
    protected AccessDatastoreDialog(@Nullable final AccessDatastore originalDatastore,
            final MutableDatastoreCatalog mutableDatastoreCatalog, final WindowContext windowContext,
            final UserPreferences userPreferences) {
        super(originalDatastore, mutableDatastoreCatalog, windowContext, userPreferences);
    }

    @Override
    protected String getBannerTitle() {
        return "MS Access database";
    }

    @Override
    public String getWindowTitle() {
        return "MS Access database | Datastore";
    }

    @Override
    protected AccessDatastore createDatastore(final String name, final String filename) {
        return new AccessDatastore(name, filename);
    }

    @Override
    protected String getDatastoreIconPath() {
        return IconUtils.ACCESS_IMAGEPATH;
    }

    @Override
    protected void setFileFilters(final AbstractResourceTextField<?> filenameField) {
        final FileFilter combinedFilter =
                FileFilters.combined("Any Access database (.mdb, .accdb)", FileFilters.MDB, FileFilters.ACCDB);
        filenameField.addChoosableFileFilter(FileFilters.MDB);
        filenameField.addChoosableFileFilter(FileFilters.ACCDB);
        filenameField.addChoosableFileFilter(FileFilters.ALL);
        filenameField.setSelectedFileFilter(combinedFilter);
    }
}
